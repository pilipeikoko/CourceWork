package com.bsuir.classdiagram.model;

import java.util.List;

public class CustomField {
    private final List<CustomModifier> customModifiers;
    private final String name;

    private CustomField(List<CustomModifier> customModifiers, String fieldName) {
        this.customModifiers = customModifiers;
        this.name = fieldName;
    }

    public static CustomField of(List<CustomModifier> customModifiers, String fieldName) {
        return new CustomField(customModifiers, fieldName);
    }

    public List<CustomModifier> getModifiers() {
        return customModifiers;
    }

    public String getName() {
        return name;
    }
}
