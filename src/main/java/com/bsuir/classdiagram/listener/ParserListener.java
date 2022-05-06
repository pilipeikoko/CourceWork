package com.bsuir.classdiagram.listener;

import com.bsuir.classdiagram.model.CustomStructure;
import com.bsuir.classdiagram.util.parser.JavaParserBaseListener;

public abstract class ParserListener extends JavaParserBaseListener {
    private final CustomStructure customStructure;

    public ParserListener(CustomStructure customStructure) {
        this.customStructure = customStructure;
    }

    public CustomStructure getStructure() {
        return customStructure;
    }
}
