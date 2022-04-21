package com.bsuir.classdiagram.model;

public class CustomPackage {
    private final String modifier;
    private final String text;

    private CustomPackage(String modifier, String text) {
        this.modifier = modifier;
        this.text = text;
    }
    public static CustomPackage of(String text){
        return new CustomPackage("package", text);
    }

    public String getText() {
        return text;
    }

    public String getModifier() {
        return modifier;
    }


}
