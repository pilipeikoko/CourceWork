// Generated from com/skurski/antlr/Java.g4 by ANTLR 4.3
package com.bsuir.converter.generated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.MethodDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(@NotNull com.bsuir.converter.generated.JavaParser.ConstantContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(@NotNull com.bsuir.converter.generated.JavaParser.MethodBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(@NotNull com.bsuir.converter.generated.JavaParser.ClassModifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(@NotNull com.bsuir.converter.generated.JavaParser.ModifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#methodParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodParameters(@NotNull com.bsuir.converter.generated.JavaParser.MethodParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.TypeDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(@NotNull com.bsuir.converter.generated.JavaParser.ClassNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(@NotNull com.bsuir.converter.generated.JavaParser.ReturnStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull com.bsuir.converter.generated.JavaParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.ClassDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull com.bsuir.converter.generated.JavaParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(@NotNull com.bsuir.converter.generated.JavaParser.VariableDeclaratorContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.ClassBodyDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by the {@code calcExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcExpression(@NotNull com.bsuir.converter.generated.JavaParser.CalcExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(@NotNull com.bsuir.converter.generated.JavaParser.MemberContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.ImportDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(@NotNull com.bsuir.converter.generated.JavaParser.PrimitiveTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(@NotNull com.bsuir.converter.generated.JavaParser.ParExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(@NotNull com.bsuir.converter.generated.JavaParser.VariableInitializerContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(@NotNull com.bsuir.converter.generated.JavaParser.VariableNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(@NotNull com.bsuir.converter.generated.JavaParser.QualifiedNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.FieldDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by the {@code statementExpression}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(@NotNull com.bsuir.converter.generated.JavaParser.StatementExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(@NotNull com.bsuir.converter.generated.JavaParser.MethodNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code notEqualExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualExpression(@NotNull com.bsuir.converter.generated.JavaParser.NotEqualExpressionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(@NotNull com.bsuir.converter.generated.JavaParser.WhileStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#methodParametersDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodParametersDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.MethodParametersDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(@NotNull com.bsuir.converter.generated.JavaParser.PackageDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#compilation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilation(@NotNull com.bsuir.converter.generated.JavaParser.CompilationContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavaParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(@NotNull com.bsuir.converter.generated.JavaParser.InstructionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(@NotNull com.bsuir.converter.generated.JavaParser.EqualityExpressionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(@NotNull com.bsuir.converter.generated.JavaParser.LiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condStatement}
	 * labeled alternative in {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondStatement(@NotNull com.bsuir.converter.generated.JavaParser.CondStatementContext ctx);

	/**
	 * Visit a parse tree produced by the {@code incDecExpression}
	 * labeled alternative in {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDecExpression(@NotNull com.bsuir.converter.generated.JavaParser.IncDecExpressionContext ctx);
}