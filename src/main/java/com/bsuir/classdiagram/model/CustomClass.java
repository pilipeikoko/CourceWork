package com.bsuir.classdiagram.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomClass {
    private final List<CustomModifier> customModifiers;
    private final String type;
    private final String name;
    private final List<CustomType> customTypes;
    private List<CustomField> customFields;
    private List<CustomMethod> customMethods;

    CustomClass(List<CustomModifier> customModifiers, String type, String className, List<CustomType> customTypes) {
        this.customModifiers = customModifiers;
        this.type = type;
        this.name = className;
        this.customTypes = customTypes;
    }

    public void addField(CustomField customField) {
        int a;
        int b = 2;
        if(1 == b){
            b=2;
        }
        while (1 == b){
            b=2;
        }
        if (Objects.isNull(customFields)) {
            customFields = new ArrayList<>();
        }
        customFields.add(customField);
    }

    public void addMethod(CustomMethod customMethod) {
        if (Objects.isNull(customMethods)) {
            customMethods = new ArrayList<>();
        }
        customMethods.add(customMethod);
    }

    public String getType() {
        return type;
    }

    public List<CustomType> getTypes() {
        return customTypes;
    }

    public String getName() {
        return name;
    }

    public List<CustomModifier> getModifiers() {
        return customModifiers;
    }

    public List<CustomField> getFields() {
        return customFields;
    }

    public List<CustomMethod> getMethods() {
        return customMethods;
    }
}
