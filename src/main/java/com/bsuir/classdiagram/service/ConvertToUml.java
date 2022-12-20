package com.bsuir.classdiagram.service;

import com.bsuir.classdiagram.model.*;
import com.bsuir.classdiagram.util.FileUtility;
import com.bsuir.classdiagram.util.mapper.ModifierMapper;
import net.sourceforge.plantuml.SourceFileReader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.bsuir.classdiagram.util.UmlGeneratorConstants.*;
import static java.util.stream.Collectors.joining;

public class ConvertToUml {
    private List<CompilationUnit> structures;
    private ModifierMapper modifierMapper;

    public ConvertToUml(ModifierMapper modifierMapper) {
        this.modifierMapper = modifierMapper;
    }

    public String parse(List<CustomStructure> structures) throws IOException {
        init(structures);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(startLines());
        stringBuilder.append(parseClasses());
        stringBuilder.append(parseClassRelation());
        stringBuilder.append(format(stringBuilder.toString()));

        String umlResult = stringBuilder.toString();

        FileUtility utility = new FileUtility();
        utility.write(umlResult);

        generatePngPicture();

        return umlResult;
    }

    private String startLines() {
        return START_TOKEN +
                DEFAULT_STYLE_TOKEN +
                NEW_LINE;
    }

    private void init(List<CustomStructure> structures) {
        this.structures = structures.stream().map(item ->
                        (CompilationUnit) item)
                .filter(item -> item.getCustomClass() != null &&  !Objects.equals(item.getCustomClass().getType(), ANNOTATION_TOKEN))
                .collect(Collectors.toList());
    }

    private String parseClassRelation() {
        StringBuilder stringBuilder = new StringBuilder();
        structures
                .forEach(structure -> structure.getCustomClasses()
                        .forEach(customClass -> {
                            List<CustomType> types = customClass.getTypes();
                            String className = customClass.getName();
                            for (int i = 0; i < types.size(); i += 2) {
                                String parent = types.get(i + 1).getText();
                                String parentModifier = types.get(i).getText();
                                Arrays.asList(parent.split(","))
                                        .forEach(item -> stringBuilder.append(item)
                                                .append(" --> ")
                                                .append(className)
                                                .append(" : ")
                                                .append(parentModifier)
                                                .append("↑")
                                                .append(NEW_LINE));
                            }
                        }));

        return stringBuilder.toString();
    }

    private void generatePngPicture() throws IOException {
        SourceFileReader reader = new SourceFileReader(new File(UML_SAVE_PATH));
        reader.getGeneratedImages();
    }

    private String format(String text) {
        return text +
                NEW_LINE +
                END_TOKEN;
    }

    private String parseClasses() {
        StringBuilder stringBuilder = new StringBuilder();
        structures.forEach(structure -> {
            boolean hasPackage = Objects.nonNull(structure.getCustomPackage());
            if (hasPackage) {
                stringBuilder.append("package").append(SPACE_TOKEN)
                        .append(structure.getCustomPackage().getText())
                        .append("{")
                        .append(NEW_LINE);

            }
            CustomClass customClass = structure.getCustomClass();
            if (hasPackage) {
                stringBuilder.append("package").append(SPACE_TOKEN)
                        .append(customClass.getName()).append(SPACE_TOKEN)
                        .append("<<").append(WRAP_CLASS_STYLE_TOKEN)
                        .append(">>")
                        .append("{")
                        .append(NEW_LINE);
            }
            stringBuilder
                    .append(customClass.getType())
                    .append(SPACE_TOKEN)
                    .append(customClass.getName())
                    .append("{")
                    .append(NEW_LINE);

            if (!Params.isExportClassOnly()) {
                stringBuilder.append(parseFields(customClass.getFields()));
                stringBuilder.append(parseMethods(customClass.getMethods()));
            }

            stringBuilder
                    .append(NEW_LINE)
                    .append("}")
                    .append(NEW_LINE);

            if (hasPackage) {
                stringBuilder.append("}\n}")
                        .append(NEW_LINE);
            }
        });
        return stringBuilder.toString();
    }

    private String parseMethods(List<CustomMethod> methods) {
        StringBuilder builder = new StringBuilder();
        if (Objects.nonNull(methods)) {
            methods.forEach(method -> {
                builder
                        .append(modifierTokens(method.getModifiers()))
                        .append(method.getName())
                        .append(SPACE_TOKEN);
                List<CustomMethod.Param> params = method.getParams();
                if (Objects.nonNull(params)) {
                    builder
                            .append("(")
                            .append(
                                    params.stream()
                                            .map(CustomMethod.Param::getName)
                                            .collect(joining(","))
                            );
                    builder.append(")")
                            .append(NEW_LINE);
                }

            });
        }
        return builder.toString();
    }

    private String parseFields(List<CustomField> fields) {
        StringBuilder builder = new StringBuilder();
        if (Objects.nonNull(fields)) {
            fields.forEach(field ->
                    builder
                            .append(modifierTokens(field.getModifiers()))
                            .append(field.getName())
                            .append(NEW_LINE));
        }
        builder.append("\n");

        return builder.toString();
    }

    private String modifierTokens(List<CustomModifier> modifiers) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < modifiers.size(); ++i) {
            String text = modifierMapper.Map(modifiers.get(i).getModifier());
            if (i == 0) {
                result.append(modifierIcon(text))
                        .append(SPACE_TOKEN);
                continue;
            }
            result.append(text)
                    .append(SPACE_TOKEN);
        }
        return result.toString();
    }

    private String modifierIcon(String text) {
        if (Objects.equals(text, PUBLIC_MODIFIER_TOKEN)) {
            return "+";
        }
        if (Objects.equals(text, PROTECTED_MODIFIER_TOKEN)) {
            return "#";
        }
        if (Objects.equals(text, PRIVATE_MODIFIER_TOKEN)) {
            return "-";
        }
        return "~ " + text;
    }


}
