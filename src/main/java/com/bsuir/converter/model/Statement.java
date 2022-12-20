package com.bsuir.converter.model;


import java.util.*;

public class Statement implements Printer {

    private String type;

    private Expression expression;

    private List<Statement> statements = Collections.emptyList();

    public Statement(Expression expression) {
        this.expression = expression;
    }

    public Statement(String type, Expression expression) {
        this.type = type;
        this.expression = expression;
    }

    public Statement(String type, Expression expression, List<Statement> statements) {
        this.type = type;
        this.expression = expression;
        this.statements = statements;
    }

    @Override
    public String printToC() {
        StringBuilder sb = new StringBuilder();

        if (type.equals("return")) {
            sb.append("return " + expression.printToC() + ";");
        }

        if (type.equals("if")) {
            sb.append("if (" + expression.printToC() + ")");
        }

        if (type.equals("while")) {
            sb.append("while (" + expression.printToC() + ")");
        }

        if (type.equals("assign")) {
            sb.append(expression.printToC() + ";");
        }

        for (int i=0; i<statements.size(); i++) {
            if (i == 0) {
                sb.append(" {\n\t\t" + statements.get(0).printToC() + "\n\t}");
            }
            if (i == 1) {
                sb.append(" else {\n\t\t" + statements.get(1).printToC() + "\n\t}");
            }
        }

        return sb.toString();
    }
}
