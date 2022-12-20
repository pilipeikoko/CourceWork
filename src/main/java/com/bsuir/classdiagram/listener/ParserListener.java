package com.bsuir.classdiagram.listener;

import com.bsuir.classdiagram.model.CustomStructure;
import com.bsuir.classdiagram.util.mapper.ModifierMapper;
import com.bsuir.parser.JavaParserBaseListener;

public abstract class ParserListener extends JavaParserBaseListener {
    protected final CustomStructure customStructure;
    protected final ModifierMapper modifierMapper;

    public ParserListener(CustomStructure customStructure, ModifierMapper modifierMapper) {
        this.customStructure = customStructure;
        this.modifierMapper = modifierMapper;
    }

    public CustomStructure getStructure() {
        return customStructure;
    }
}
