package com.bsuir.classdiagram.service;

import com.bsuir.classdiagram.model.CustomStructure;
import com.bsuir.classdiagram.util.FileUtility;
import com.bsuir.classdiagram.util.mapper.JavaModifierMapper;
import com.bsuir.parser.JavaParser;

import java.io.IOException;
import java.util.List;

public class JavaService {

    public void parse(String projectDir) throws IOException {
        var fileUtility = new FileUtility();
        var modifierMapper = new JavaModifierMapper();
        ParserService<JavaParser> service = new JavaParserService(fileUtility, modifierMapper);

        List<CustomStructure> structures = service.parse(projectDir);

        ConvertToUml javaUml = new ConvertToUml(modifierMapper);
        String uml = javaUml.parse(structures);

        FileUtility utility = new FileUtility();
        utility.write(uml);
    }
}
