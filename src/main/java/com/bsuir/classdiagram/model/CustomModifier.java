package com.bsuir.classdiagram.model;

public class CustomModifier {
    private final String text;

    private CustomModifier(String text) {
        this.text = text;
    }

    public static CustomModifier of(String text) {
        return new CustomModifier(text);
    }

    public String getText() {
        return text;
    }
}
