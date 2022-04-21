package com.bsuir.classdiagram.model;

import java.util.List;

public class CustomMethod {
    private final List<CustomModifier> customModifiers;
    private final boolean isConstructor;
    private final String name;
    private final List<Param> params;

    private CustomMethod(boolean isConstructor, List<CustomModifier> customModifiers, String methodName, List<Param> params) {
        this.isConstructor = isConstructor;
        this.customModifiers = customModifiers;
        this.name = methodName;
        this.params = params;
    }

    public static Param ofParam(String text) {
        return new Param(text);
    }

    public static CustomMethod of(boolean isConstructor, List<CustomModifier> customModifiers, String methodName, List<Param> params) {
        return new CustomMethod(isConstructor, customModifiers, methodName, params);
    }


    public static class Param {
        private final String name;

        Param(String text) {
            this.name = text;
        }

        public String getName() {
            return name;
        }
    }

    public List<CustomModifier> getModifiers() {
        return customModifiers;
    }

    public boolean isConstructor() {
        return isConstructor;
    }

    public String getName() {
        return name;
    }

    public List<Param> getParams() {
        return params;
    }
}
