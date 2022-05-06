package com.bsuir.classdiagram.service;

import com.bsuir.classdiagram.model.CustomStructure;
import com.bsuir.classdiagram.util.FileUtility;
import com.bsuir.classdiagram.util.parser.JavaParser;

import java.io.IOException;
import java.util.List;

public class JavaService {

    public void parse(String projectDir) throws IOException {
        ParserService<JavaParser> service = new JavaParserService();

        List<CustomStructure> structures = service.parse(projectDir);

        JavaUml javaUml = new JavaUml();
        String uml = javaUml.parse(structures);

        FileUtility utility = new FileUtility();
        utility.write(uml);
    }
}
