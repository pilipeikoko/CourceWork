package com.bsuir.converter.visitor;

import com.bsuir.converter.generated.JavaBaseVisitor;
import com.bsuir.converter.generated.JavaParser;
import com.bsuir.converter.model.Field;
import com.bsuir.converter.model.Method;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.xpath.XPath;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class ClassVisitor extends JavaBaseVisitor {

    private com.bsuir.converter.model.Class returnClass = null;
    private JavaParser parser;

    public ClassVisitor(JavaParser parser) {
        this.parser = parser;
    }

    @Override public Object visitCompilation(@NotNull JavaParser.CompilationContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public Object visitClassDeclaration(@NotNull JavaParser.ClassDeclarationContext ctx) {
        String className = ctx.className().getText();
        FieldVisitor fieldVisitor = new FieldVisitor();
        MethodVisitor methodVisitor = new MethodVisitor();

        List<Field> fields = ctx.classBodyDeclaration().member()
                .stream()
                .filter(object -> object.fieldDeclaration() != null)
                .map(field -> field.accept(fieldVisitor))
                .collect(Collectors.toList());

        List<Method> methods = ctx.classBodyDeclaration().member()
                .stream()
                .filter(object -> object.methodDeclaration() != null)
                .map(method -> method.accept(methodVisitor))
                .collect(Collectors.toList());

        returnClass = new com.bsuir.converter.model.Class(className, methods, fields);

        return returnClass;
    }

    private Collection<ParseTree> find(RuleContext ctx, String xpath) {
        return XPath.findAll(ctx, xpath, parser);
    }

    public com.bsuir.converter.model.Class getReturnClass() {
        return returnClass;
    }
}
