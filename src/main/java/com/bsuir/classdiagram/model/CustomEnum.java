package com.bsuir.classdiagram.model;

import java.util.Dictionary;
import java.util.List;

public class CustomEnum {
    private final List<CustomModifier> customModifiers;
    private final String type;
    private final String name;
    private final List<String> values;

    CustomEnum(List<CustomModifier> customModifiers, String type, String className, List<String> values) {
        this.customModifiers = customModifiers;
        this.type = type;
        this.name = className;
        this.values = values;
    }

    public List<CustomModifier> getCustomModifiers() {
        return customModifiers;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<String> getValues() {
        return values;
    }
}
