package com.bsuir.classdiagram.listener;

import com.bsuir.classdiagram.model.*;
import com.bsuir.classdiagram.util.mapper.ModifierMapper;
import com.bsuir.parser.JavaParser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.xpath.XPath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.bsuir.classdiagram.util.UmlGeneratorConstants.*;

public class JavaListener extends ParserListener {
    private final JavaParser parser;

    public JavaListener(CustomStructure customStructure, JavaParser parser, ModifierMapper modifierMapper) {
        super(customStructure, modifierMapper);
        this.parser = parser;
    }

    @Override
    public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
        getJavaStructure()
                .addImport(textOf(ctx));
    }

    @Override
    public void enterPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
        getJavaStructure()
                .updatePackageName(textOf(ctx));
    }

    @Override
    public void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {
        List<CustomModifier> customModifiers = parseClassModifiers(ctx);
        ParseTree classContext = ctx.getChild(customModifiers.size());
        String className = classContext.getChild(1).getText();
        String type = getCurrentType(classContext);
        List<CustomType> customTypes = parseClassTypes(classContext);
        if (type.equals("class") || type.equals("interface")) {
            getJavaStructure()
                    .addCustomClass(
                            customModifiers,
                            type,
                            className,
                            customTypes
                    );
        }
        else if (type.equals("enum")){
            getJavaStructure().addCustomEnum(customModifiers, type, className, getEnumMembers(classContext));
        }
    }

    private List<String> getEnumMembers(ParseTree classContext) {
        var values = new ArrayList<String>();
        for(int i=0;i<classContext.getChildCount();++i){
            var child = classContext.getChild(i);

            if(child instanceof JavaParser.EnumConstantsContext){
                for(int j =0;j<child.getChildCount();++j){
                    var enumValue = child.getChild(j);
                    if(enumValue instanceof JavaParser.EnumConstantContext)
                        values.add(enumValue.getText());
                }
            }
        }
        return values;
    }

    private String getCurrentType(ParseTree classContext) {
        if (classContext instanceof JavaParser.ClassDeclarationContext) {
            return CLASS_TOKEN;
        }
        if (classContext instanceof JavaParser.InterfaceDeclarationContext) {
            return INTERFACE_TOKEN;
        }
        if (classContext instanceof JavaParser.EnumDeclarationContext) {
            return ENUM_TOKEN;
        }
        return ANNOTATION_TOKEN;
    }

    @Override
    public void enterInterfaceBodyDeclaration(JavaParser.InterfaceBodyDeclarationContext ctx) {
        getJavaStructure()
                .getCustomClass()
                .addMethod(parseInterfaceMethod(ctx));
    }

    @Override
    public void enterEnumBodyDeclarations(JavaParser.EnumBodyDeclarationsContext ctx) {
        super.enterEnumBodyDeclarations(ctx);
    }


    @Override
    public void enterClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {
        if (isFieldContext(ctx)) {
            getJavaStructure()
                    .getCustomClass()
                    .addField(parseField(ctx));
        }
        if (isMethodContext(ctx)) {
            getJavaStructure()
                    .getCustomClass()
                    .addMethod(parseMethod(ctx));
        }
    }

    private CustomMethod parseInterfaceMethod(JavaParser.InterfaceBodyDeclarationContext ctx) {
        ParseTree methodContext = find(ctx, "//interfaceMethodDeclaration")
                .iterator().next();
        List<CustomMethod.Param> params = find((RuleContext) methodContext, "//formalParameter").stream()
                .map(context -> CustomMethod.ofParam(textOf((RuleContext) context)))
                .collect(Collectors.toList());
        String methodName;
        methodName = methodContext.getChild(1).getText();
        List<CustomModifier> customModifiers = parseMethodModifiers(ctx, false);
        return CustomMethod.of(false, customModifiers, methodName, params);
    }

    private CustomMethod parseMethod(JavaParser.ClassBodyDeclarationContext ctx) {
        boolean isConstructor = !find(ctx, "//constructorDeclaration").isEmpty();
        List<CustomModifier> customModifiers = parseMethodModifiers(ctx, isConstructor);
        ParseTree methodContext = find(ctx,
                isConstructor ? "//constructorDeclaration" : "//methodDeclaration")
                .iterator().next();
        List<CustomMethod.Param> params = find((RuleContext) methodContext, "//formalParameter").stream()
                .map(context -> CustomMethod.ofParam(textOf((RuleContext) context)))
                .collect(Collectors.toList());
        String methodName;
        if (isConstructor) {
            methodName = methodContext.getChild(0).getText();
        } else {
            methodName = methodContext.getChild(1).getText();
        }
        if(methodName.equals("addField")){
            var methodBodyContext = find(((RuleContext) methodContext).getRuleContext(), "//methodBody").stream().findFirst();
            if(methodBodyContext.isPresent()){
                var blockContext = find((RuleContext) methodBodyContext.get(), "//block").stream().findFirst();
                if(blockContext.isPresent()){
                    var statementContextes = find((RuleContext) blockContext.get(), "//blockStatement");
                    for (var statement : statementContextes) {
                        for (int i = 0; i < statement.getChildCount(); i++) {
                            var statementChild = statement.getChild(i);
                            if(statementChild instanceof JavaParser.LocalVariableDeclarationContext){
                                // int a;
                            }
                        }

                    }
                }
            }

        }
        return CustomMethod.of(isConstructor, customModifiers, methodName, params);
    }

    private CustomVariable parseVariable(JavaParser.LocalVariableDeclarationContext ctx){
        return new CustomVariable();
    }

    private CustomField parseField(JavaParser.ClassBodyDeclarationContext ctx) {
        List<CustomModifier> customModifiers = findModifiers(ctx).stream()
                .filter(modifier -> !modifierMapper.Map(modifier.getModifier()).startsWith("@"))
                .collect(Collectors.toList());
        String fieldName = find(ctx, "//variableDeclaratorId").iterator().next().getText();
        return CustomField.of(customModifiers, fieldName);
    }

    private CustomField parseExpression(JavaParser.ExpressionContext ctx) {
        List<CustomModifier> customModifiers = findModifiers(ctx).stream()
                .filter(modifier -> !modifierMapper.Map(modifier.getModifier()).startsWith("@"))
                .collect(Collectors.toList());
        String fieldName = find(ctx, "//variableDeclaratorId").iterator().next().getText();
        return CustomField.of(customModifiers, fieldName);
    }

    private List<CustomModifier> findModifiers(RuleContext ctx) {
        List<CustomModifier> classOrInterfaceCustomModifiers = find(ctx, "//classOrInterfaceModifier").stream()
                .map(context -> CustomModifier.of(modifierMapper.Map(context.getText())))
                .collect(Collectors.toList());

        List<CustomModifier> classOrInterfaceTypes = find(ctx, "//classOrInterfaceType").stream()
                .map(context -> CustomModifier.of(modifierMapper.Map(context.getText()))).collect(Collectors.toList());
        if (!classOrInterfaceTypes.isEmpty()) {
            classOrInterfaceCustomModifiers.add(classOrInterfaceTypes.get(0));
            return classOrInterfaceCustomModifiers;
        }
        List<CustomModifier> basicTypes = find(ctx, "//typeType").stream()
                .map(context -> CustomModifier.of(modifierMapper.Map(context.getText()))).collect(Collectors.toList());
        if (!basicTypes.isEmpty()) {
            classOrInterfaceCustomModifiers.add(basicTypes.get(0));
            return basicTypes;
        }
        return new ArrayList<>();
    }

    private Collection<ParseTree> find(RuleContext ctx, String xpath) {
        return XPath.findAll(ctx, xpath, parser);
    }

    private boolean isMethodContext(JavaParser.ClassBodyDeclarationContext ctx) {
        Collection<ParseTree> methods = find(ctx, "//methodDeclaration");
        Collection<ParseTree> constructors = find(ctx, "//constructorDeclaration");
        return !(methods.isEmpty() && constructors.isEmpty());
    }

    private boolean isFieldContext(JavaParser.ClassBodyDeclarationContext ctx) {
        Collection<ParseTree> matches = find(ctx, "//*/memberDeclaration/fieldDeclaration");
        return !matches.isEmpty();
    }

    private List<CustomType> parseClassTypes(ParseTree context) {
        List<CustomType> result = new ArrayList<>();
        for (int i = 2; i < context.getChildCount(); ++i) {
            ParseTree child = context.getChild(i);
            if (child instanceof JavaParser.ClassBodyContext
                    ||
                    child instanceof JavaParser.InterfaceBodyContext) {
                continue;
            }
            if (child instanceof TerminalNode) {
                result.add(CustomType.of(child.getText()));
                continue;
            }
            String text = textOf((RuleContext) child).split("<")[0];
            if (text.isEmpty()) {
                continue;
            }
            result.add(CustomType.of(text));
        }
        return result;
    }

    private List<CustomModifier> parseClassModifiers(RuleContext ctx) {
        List<CustomModifier> result = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); ++i) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof JavaParser.ClassOrInterfaceModifierContext) {
                result.add(CustomModifier.of(modifierMapper.Map(child.getText())));
            }
        }
        return result;
    }

    private List<CustomModifier> parseMethodModifiers(RuleContext ctx, boolean isConstructor) {
        List<CustomModifier> result = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); ++i) {
            ParseTree child = ctx.getChild(i);
            boolean isAnnotation = child.getText().startsWith("@");
            if (isAnnotation) continue;

            if (child instanceof JavaParser.ModifierContext) {
                result.add(CustomModifier.of(modifierMapper.Map(child.getText())));
            }
            if ((child instanceof JavaParser.MemberDeclarationContext
                    ||
                    child instanceof JavaParser.InterfaceMemberDeclarationContext
            )
                    &&
                    !isConstructor) {
                result.add(CustomModifier.of(modifierMapper.Map(child.getChild(0).getChild(0).getText())));
            }
        }
        return result;
    }

    private CompilationUnit getJavaStructure() {
        return (CompilationUnit) getStructure();
    }

    private String textOf(RuleContext context) {
        TokenStream tokenStream = parser.getTokenStream();
        return tokenStream.getText(context.getSourceInterval());
    }
}
