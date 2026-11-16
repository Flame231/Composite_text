package org.example;

import org.example.component.Component;
import org.example.componentType.ComponentType;
import org.example.component.impl.Composite;
import org.example.parser.*;
import org.example.parser.impl.*;
import org.example.reader.impl.CustomTextTextReader;
import org.example.reader.TextReader;
import org.example.service.DocumentService;

import java.io.IOException;
import java.nio.file.Path;

public class App {

    public static final Path filePath = Path.of("add/text.txt");

    public static void main(String[] args) throws IOException {
        TextReader textReader = new CustomTextTextReader();
        String text = textReader.read(filePath);
        Parser symbolParser = new SymbolParser();
        Parser wordParser = new WordParser(symbolParser);
        Parser lexemeParser = new LexemeParser(wordParser);
        Parser sentenceParser = new SentenceParser(lexemeParser);
        Parser paragraphParser = new ParagraphParser(sentenceParser);
        Component component = new Composite(paragraphParser.handle(text, ComponentType.PARAGRAPH));
        component.setComponentType(ComponentType.DOCUMENT);
        DocumentService documentService = new DocumentService();
        System.out.println(component.getValue());
        System.out.println(component.getSize());
    }
}
