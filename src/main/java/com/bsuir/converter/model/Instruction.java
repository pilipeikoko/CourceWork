package com.bsuir.converter.model;

import java.util.List;

public class Instruction implements Printer {

    private List<Variable> variables;

    private List<Statement> statements;

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String printToC() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");

        for (Variable var : variables) {
            sb.append(var.printToC());
            sb.append("\n");
        }

        for (Statement stat : statements) {
            sb.append(stat.printToC());
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "variables=" + variables +
                ", statements=" + statements +
                '}';
    }
}
