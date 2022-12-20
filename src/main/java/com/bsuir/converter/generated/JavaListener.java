// Generated from com/skurski/antlr/Java.g4 by ANTLR 4.3
package com.bsuir.converter.generated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaParser}.
 */
public interface JavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.MethodDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull com.bsuir.converter.generated.JavaParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull com.bsuir.converter.generated.JavaParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(@NotNull com.bsuir.converter.generated.JavaParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(@NotNull com.bsuir.converter.generated.JavaParser.MethodBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(@NotNull com.bsuir.converter.generated.JavaParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(@NotNull com.bsuir.converter.generated.JavaParser.ClassModifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(@NotNull com.bsuir.converter.generated.JavaParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(@NotNull com.bsuir.converter.generated.JavaParser.ModifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#methodParameters}.
	 * @param ctx the parse tree
	 */
	void enterMethodParameters(@NotNull com.bsuir.converter.generated.JavaParser.MethodParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodParameters}.
	 * @param ctx the parse tree
	 */
	void exitMethodParameters(@NotNull com.bsuir.converter.generated.JavaParser.MethodParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.TypeDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(@NotNull com.bsuir.converter.generated.JavaParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(@NotNull com.bsuir.converter.generated.JavaParser.ClassNameContext ctx);

	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(@NotNull com.bsuir.converter.generated.JavaParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(@NotNull com.bsuir.converter.generated.JavaParser.ReturnStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull com.bsuir.converter.generated.JavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull com.bsuir.converter.generated.JavaParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.ClassDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull com.bsuir.converter.generated.JavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull com.bsuir.converter.generated.JavaParser.LiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(@NotNull com.bsuir.converter.generated.JavaParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(@NotNull com.bsuir.converter.generated.JavaParser.VariableDeclaratorContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.ClassBodyDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by the {@code calcExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCalcExpression(@NotNull com.bsuir.converter.generated.JavaParser.CalcExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code calcExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCalcExpression(@NotNull com.bsuir.converter.generated.JavaParser.CalcExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(@NotNull com.bsuir.converter.generated.JavaParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(@NotNull com.bsuir.converter.generated.JavaParser.MemberContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.ImportDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull com.bsuir.converter.generated.JavaParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull com.bsuir.converter.generated.JavaParser.PrimitiveTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(@NotNull com.bsuir.converter.generated.JavaParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(@NotNull com.bsuir.converter.generated.JavaParser.ParExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(@NotNull com.bsuir.converter.generated.JavaParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(@NotNull com.bsuir.converter.generated.JavaParser.VariableInitializerContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(@NotNull com.bsuir.converter.generated.JavaParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(@NotNull com.bsuir.converter.generated.JavaParser.VariableNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(@NotNull com.bsuir.converter.generated.JavaParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(@NotNull com.bsuir.converter.generated.JavaParser.QualifiedNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.FieldDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by the {@code statementExpression}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(@NotNull com.bsuir.converter.generated.JavaParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementExpression}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(@NotNull com.bsuir.converter.generated.JavaParser.StatementExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(@NotNull com.bsuir.converter.generated.JavaParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(@NotNull com.bsuir.converter.generated.JavaParser.MethodNameContext ctx);

	/**
	 * Enter a parse tree produced by the {@code notEqualExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualExpression(@NotNull com.bsuir.converter.generated.JavaParser.NotEqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqualExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualExpression(@NotNull com.bsuir.converter.generated.JavaParser.NotEqualExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(@NotNull com.bsuir.converter.generated.JavaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(@NotNull com.bsuir.converter.generated.JavaParser.WhileStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#methodParametersDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodParametersDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.MethodParametersDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodParametersDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodParametersDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.MethodParametersDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.PackageDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#compilation}.
	 * @param ctx the parse tree
	 */
	void enterCompilation(@NotNull com.bsuir.converter.generated.JavaParser.CompilationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#compilation}.
	 * @param ctx the parse tree
	 */
	void exitCompilation(@NotNull com.bsuir.converter.generated.JavaParser.CompilationContext ctx);

	/**
	 * Enter a parse tree produced by {@link JavaParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(@NotNull com.bsuir.converter.generated.JavaParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(@NotNull com.bsuir.converter.generated.JavaParser.InstructionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(@NotNull com.bsuir.converter.generated.JavaParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(@NotNull com.bsuir.converter.generated.JavaParser.EqualityExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(@NotNull com.bsuir.converter.generated.JavaParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(@NotNull com.bsuir.converter.generated.JavaParser.LiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code condStatement}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCondStatement(@NotNull com.bsuir.converter.generated.JavaParser.CondStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condStatement}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCondStatement(@NotNull com.bsuir.converter.generated.JavaParser.CondStatementContext ctx);

	/**
	 * Enter a parse tree produced by the {@code incDecExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIncDecExpression(@NotNull com.bsuir.converter.generated.JavaParser.IncDecExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code incDecExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIncDecExpression(@NotNull com.bsuir.converter.generated.JavaParser.IncDecExpressionContext ctx);
}