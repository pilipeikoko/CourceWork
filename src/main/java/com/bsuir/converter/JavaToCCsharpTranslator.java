package com.bsuir.converter;

import com.bsuir.classdiagram.util.FileUtility;
import com.bsuir.converter.generated.JavaLexer;
import com.bsuir.converter.generated.JavaParser;
import com.bsuir.converter.model.Output;
import com.bsuir.converter.visitor.ClassVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.InputStream;

import static com.bsuir.classdiagram.util.UmlGeneratorConstants.CODE_SAVE_PATH;

public class JavaToCCsharpTranslator {
    public static void translate(String location) throws Exception {
        FileUtility fileUtility = new FileUtility();
        InputStream in = new FileInputStream(location);
        ANTLRInputStream input = new ANTLRInputStream(in);

        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);

        ClassVisitor classVisitor = new ClassVisitor(parser);
        classVisitor.visit(parser.compilation());
        com.bsuir.converter.model.Class traverseResult = classVisitor.getReturnClass();
        Output output = new Output(traverseResult, fileUtility);
        output.printToCSharp(CODE_SAVE_PATH + "/" + location.substring(location.lastIndexOf("\\") + 1));
    }
}
