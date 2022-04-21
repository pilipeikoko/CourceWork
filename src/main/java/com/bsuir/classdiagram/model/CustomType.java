package com.bsuir.classdiagram.model;

public class CustomType {
    private final String text;

    public CustomType(String text) {
        this.text = text;
    }

    public static CustomType of(String text) {
        return new CustomType(text);
    }

    public String getText() {
        return text;
    }


}
