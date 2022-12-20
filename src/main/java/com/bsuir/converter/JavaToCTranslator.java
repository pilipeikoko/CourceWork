package com.bsuir.converter;

import com.bsuir.converter.generated.JavaLexer;
import com.bsuir.converter.generated.JavaParser;
import com.bsuir.converter.model.Output;
import com.bsuir.converter.visitor.ClassVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class JavaToCTranslator {

    public static void translate(String location) throws Exception {

        InputStream in = new FileInputStream(location);
        ANTLRInputStream input = new ANTLRInputStream(in);

        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);

        ClassVisitor classVisitor = new ClassVisitor(parser);
        classVisitor.visit(parser.compilation());
        com.bsuir.converter.model.Class traverseResult = classVisitor.getReturnClass();

        Output output = new Output(traverseResult);
        output.printToC();
    }
}