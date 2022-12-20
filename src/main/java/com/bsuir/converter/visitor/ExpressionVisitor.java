package com.bsuir.converter.visitor;

import com.bsuir.converter.generated.JavaBaseVisitor;
import com.bsuir.converter.generated.JavaParser;
import com.bsuir.converter.model.Expression;
import org.antlr.v4.runtime.misc.NotNull;

public class ExpressionVisitor extends JavaBaseVisitor<Expression> {

    @Override
    public Expression visitLiteralExpression(@NotNull JavaParser.LiteralExpressionContext ctx) {
        Expression expression = new Expression(ctx.getText());
        return expression;
    }

    @Override
    public Expression visitCalcExpression(@NotNull JavaParser.CalcExpressionContext ctx) {
        Expression expression = new Expression();
        expression.setLeftValue(new Expression(ctx.expression().get(0).getText()));
        expression.setOperation(ctx.op.getText());
        expression.setRightValue(new Expression(ctx.expression().get(1).getText()));
        return expression;
    }

    @Override
    public Expression visitEqualityExpression(@NotNull JavaParser.EqualityExpressionContext ctx) {
        Expression expression = new Expression();
        expression.setLeftValue(new Expression(ctx.expression().get(0).getText()));
        expression.setOperation(ctx.op.getText());
        expression.setRightValue(new Expression(ctx.expression().get(1).getText()));
        return expression;
    }

    @Override
    public Expression visitNotEqualExpression(@NotNull JavaParser.NotEqualExpressionContext ctx) {
        Expression expression = new Expression();
        expression.setLeftValue(new Expression(ctx.expression().get(0).getText()));
        expression.setOperation(ctx.op.getText());
        expression.setRightValue(new Expression(ctx.expression().get(1).getText()));
        return expression;
    }

    @Override
    public Expression visitIncDecExpression(@NotNull JavaParser.IncDecExpressionContext ctx) {
        Expression expression = new Expression(ctx.getText());
        return expression;
    }
}
