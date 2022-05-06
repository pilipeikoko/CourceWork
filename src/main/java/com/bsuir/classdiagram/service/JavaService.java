package com.bsuir.classdiagram.service;

import com.bsuir.classdiagram.model.CustomStructure;
import com.bsuir.classdiagram.util.parser.JavaParser;

import java.io.IOException;
import java.util.List;

public class JavaService {

    public void parse(String projectDir) throws IOException {
        ParserService<JavaParser> service = new JavaParserService();

        List<CustomStructure> structures = service.parse(projectDir);
        //TODO: add converter to puml
    }
}
