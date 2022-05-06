package com.bsuir.classdiagram.service;

import com.bsuir.classdiagram.model.CustomStructure;
import com.bsuir.classdiagram.util.FileUtil;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ParserService<T extends Parser> {

    protected abstract String getExtension();

    protected abstract List<CustomStructure> GetStructures(List<T> parsers);

    protected abstract Lexer createLexer(CharStream stream);

    protected abstract T createParser(CommonTokenStream stream);

    protected List<T> toParses(List<String> filePaths) throws IOException {
        List<T> results = new ArrayList<>();
        for (String file : filePaths) {
            CharStream charStream = CharStreams.fromPath(Paths.get(file));

            Lexer lexer = createLexer(charStream);
            T parser = createParser(new CommonTokenStream(lexer));

            results.add(parser);
        }
        return results;
    }

    public List<CustomStructure> parse(String projectDir) throws IOException {
        List<String> filePaths = FileUtil.findFilesPathBy(new File(projectDir));
        filePaths = filePaths.stream().filter(item -> item.endsWith(getExtension()))
                .collect(Collectors.toList());
        List<T> parsers = toParses(filePaths);

        return GetStructures(parsers);
    }
}
