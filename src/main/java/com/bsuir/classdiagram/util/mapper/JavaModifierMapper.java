package com.bsuir.classdiagram.util.mapper;

import com.bsuir.classdiagram.model.TypeModifier;

public class JavaModifierMapper extends ModifierMapper {
    @Override
    public TypeModifier Map(String value) {
       return switch (value){
           case "public" -> TypeModifier.PUBLIC;
           case "protected" -> TypeModifier.PROTECTED;
           case "private" -> TypeModifier.PRIVATE;
           case "" -> TypeModifier.PACKAGE_PRIVATE;
           case "final" -> TypeModifier.FINAL;
           case "static" -> TypeModifier.STATIC;
           case "abstract" -> TypeModifier.ABSTRACT;
           default -> TypeModifier.NONE;
       };
    }

    @Override
    public String Map(TypeModifier value) {
        return switch (value){
            case PUBLIC -> "public";
            case PROTECTED -> "protected";
            case PRIVATE -> "private";
            case FINAL -> "final";
            case STATIC -> "static";
            case ABSTRACT -> "abstract";
            default -> "";
        };
    }
}
