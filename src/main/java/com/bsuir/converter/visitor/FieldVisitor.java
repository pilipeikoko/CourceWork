package com.bsuir.converter.visitor;

import com.bsuir.converter.generated.JavaBaseVisitor;
import com.bsuir.converter.generated.JavaParser;
import com.bsuir.converter.model.Field;
import org.antlr.v4.runtime.misc.NotNull;

public class FieldVisitor extends JavaBaseVisitor<Field> {

    @Override
    public Field visitFieldDeclaration(@NotNull JavaParser.FieldDeclarationContext ctx) {
        Field field = new Field();
        field.setModifier(ctx.modifier().getText());
        field.setConstant(ctx.constant() != null ? true : false);
        field.setReturnType(ctx.variableDeclarator().type().getText());
        field.setName(ctx.variableDeclarator().variableName().getText());
        field.setValue(ctx.variableDeclarator().variableInitializer().expression().getText());
        field.setConstant(ctx.constant() != null);
        return field;
    }

}
