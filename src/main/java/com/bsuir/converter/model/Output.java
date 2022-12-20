package com.bsuir.converter.model;

import java.util.ArrayList;
import java.util.List;

public class Output {

    private List<String> functions = new ArrayList<>();

    private List<String> globalVariables = new ArrayList<>();

    private List<String> constants = new ArrayList<>();

    private Class input;

    public Output(Class input) {
        this.input = input;
    }

    public void printToC() {
        System.out.println(prepare());
    }

    public String prepare() {
        convert();

        StringBuilder sb = new StringBuilder();
        sb.append("#include <stdio.h>");
        sb.append("\n\n");

        for (String row : constants) {
            sb.append(row);
        }

        sb.append("\n");

        for (String row : globalVariables) {
            sb.append(row);
        }

        sb.append("\n");

        for (String row : functions) {
            sb.append(row);
        }

        return sb.toString();
    }

    private void convert() {
        for (Field field : input.getFields()) {
            if (field.isConstant()) {
                constants.add(new StringBuilder(field.printToC()).toString());
            } else {
                globalVariables.add(new StringBuilder(field.printToC()).toString());
            }
        }
        for (Method method : input.getMethods()) {
            functions.add(new StringBuilder(method.printToC()).toString());
        }
    }
}
