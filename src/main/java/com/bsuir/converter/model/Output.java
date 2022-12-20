package com.bsuir.converter.model;

import com.bsuir.classdiagram.util.FileUtility;

import java.util.ArrayList;
import java.util.List;

public class Output {

    private List<String> functions = new ArrayList<>();
    private List<String> globalVariables = new ArrayList<>();
    private List<String> constants = new ArrayList<>();
    private Class input;
    private FileUtility fileUtility;

    public Output(Class input, FileUtility fileUtility) {
        this.input = input;
        this.fileUtility = fileUtility;
    }

    public void printToC(String filename) {
        String result = prepareC();
        fileUtility.write(result, filename);
        System.out.println(prepareC());
    }

    public void printToCSharp(String filename) {
        String result = prepareC();
        fileUtility.write(result, filename);
        System.out.println(prepareCCsharp());
    }

    public String prepareCCsharp() {
        convertToCSharp();

        StringBuilder sb = new StringBuilder();
        sb.append("using System;");
        sb.append("using System.Linq;");
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

    public String prepareC() {
        convertToC();

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

    private void convertToC() {
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

    private void convertToCSharp() {
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
