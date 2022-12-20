package com.bsuir.converter.model;

/**
 * Created by psk on 25.05.17.
 */
public class Parameter implements Printer {

    private String type;

    private String name;

    public Parameter() {}

    public Parameter(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String printToC() {
        return type + " " + name;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
