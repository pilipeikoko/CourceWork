package com.bsuir.converter.visitor;

import com.bsuir.converter.generated.JavaBaseVisitor;
import com.bsuir.converter.generated.JavaParser;
import com.bsuir.converter.model.Instruction;

import com.bsuir.converter.model.Statement;
import com.bsuir.converter.model.Variable;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InstructionVisitor extends JavaBaseVisitor<Instruction> {

    @Override
    public Instruction visitInstruction(@NotNull JavaParser.InstructionContext ctx) {
        Instruction instruction = new Instruction();

        JavaParser.VariableDeclaratorContext variableContext = ctx.variableDeclarator();
        JavaParser.StatementContext statementContext = ctx.statement();

        List<Variable> variables = new ArrayList<>();
        if (variableContext != null) {
            variables.add(variableContext.accept(new VariableVisitor()));
        }

        List<Statement> statements = new ArrayList<>();
        if (statementContext != null) {
            statements.add(statementContext.accept(new StatementVisitor()));
        }

        instruction.setVariables(variables);
        instruction.setStatements(statements);
        return instruction;
    }
}
