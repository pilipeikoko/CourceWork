package com.bsuir.converter.visitor;

import com.bsuir.converter.generated.JavaBaseVisitor;
import com.bsuir.converter.generated.JavaParser;
import com.bsuir.converter.model.Variable;

import org.antlr.v4.runtime.misc.NotNull;

public class VariableVisitor extends JavaBaseVisitor<Variable> {

    @Override
    public Variable visitVariableDeclarator(@NotNull JavaParser.VariableDeclaratorContext ctx) {
        Variable variable = new Variable();
        variable.setType(ctx.type().getText());
        variable.setName(ctx.variableName().getText());
        variable.setValue(ctx.variableInitializer().expression().getText());
        return variable;
    }

}
