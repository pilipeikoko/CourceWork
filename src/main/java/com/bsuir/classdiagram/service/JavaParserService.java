package com.bsuir.classdiagram.service;

import com.bsuir.classdiagram.listener.JavaListener;
import com.bsuir.classdiagram.listener.ParserListener;
import com.bsuir.classdiagram.model.CustomStructure;
import com.bsuir.classdiagram.model.CompilationUnit;
import com.bsuir.classdiagram.util.FileUtility;
import com.bsuir.classdiagram.util.mapper.JavaModifierMapper;
import com.bsuir.parser.JavaLexer;
import com.bsuir.parser.JavaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

public class JavaParserService extends ParserService<JavaParser> {
    protected static String EXTENSION = ".java";

    protected JavaParserService(FileUtility fileUtility, JavaModifierMapper modifierMapper) {
        super(fileUtility, modifierMapper);
    }

    @Override
    public String getExtension() {
        return EXTENSION;
    }

    @Override
    protected Lexer createLexer(CharStream stream) {
        return new JavaLexer(stream);
    }

    @Override
    protected JavaParser createParser(CommonTokenStream stream) {
        return new JavaParser(stream);
    }

    @Override
    protected List<CustomStructure> GetStructures(List<JavaParser> parsers) {
        List<CustomStructure> structures = new ArrayList<>();

        parsers.forEach(parser -> {
            ParserListener listener = new JavaListener(new CompilationUnit(), parser, modifierMapper);
            JavaParser.CompilationUnitContext compilationUnitContext = parser.compilationUnit();
            ParseTreeWalker.DEFAULT.walk(listener, compilationUnitContext);
            structures.add(listener.getStructure());
        });

        return structures;
    }
}
