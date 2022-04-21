package com.bsuir.classdiagram.model;

class CustomImport {
    private final String modifier;
    private final String text;

    private CustomImport(String text) {
        this.modifier = "import";
        this.text = text;
    }


    public static CustomImport of(String text) {
        return new CustomImport(text);
    }

    public String getModifier() {
        return modifier;
    }

    public String getText() {
        return text;
    }
}
