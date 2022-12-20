package com.bsuir.classdiagram.model;

public class CustomModifier {
    private final TypeModifier modifier;

    private CustomModifier(TypeModifier text) {
        this.modifier = text;
    }

    public static CustomModifier of(TypeModifier text) {
        return new CustomModifier(text);
    }

    public TypeModifier getModifier() {
        return modifier;
    }
}
