package com.bsuir.converter.model;

import java.util.Collection;

public class Class {

    private String name;

    private Collection<Method> methods;

    private Collection<Field> fields;

    public Class(String name, Collection<Method> methods, Collection<Field> fields) {
        this.name = name;
        this.methods = methods;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Method> getMethods() {
        return methods;
    }

    public void setMethods(Collection<Method> methods) {
        this.methods = methods;
    }

    public Collection<Field> getFields() {
        return fields;
    }

    public void setFields(Collection<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", methods=" + methods +
                ", fields=" + fields +
                '}';
    }
}
