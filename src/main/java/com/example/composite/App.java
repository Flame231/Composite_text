package com.example.composite;

import com.example.composite.component.Component;
import com.example.composite.component.impl.Composite;
import com.example.composite.componentType.ComponentType;
import com.example.composite.exception.FileException;
import com.example.composite.parser.Parser;
import com.example.composite.parser.impl.*;
import com.example.composite.reader.TextReader;
import com.example.composite.reader.impl.CustomTextTextReader;
import com.example.composite.service.impl.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static final Path filePath = Path.of("add/text.txt");

    public static void main(String[] args) {
        TextReader textReader = new CustomTextTextReader();
        String text;
        try {
            log.info("Reading document from {}", filePath);
            text = textReader.read(filePath);
            Parser symbolParser = new SymbolParser();
            Parser wordParser = new WordParser(symbolParser);
            Parser lexemeParser = new LexemeParser(wordParser);
            Parser sentenceParser = new SentenceParser(lexemeParser);
            Parser paragraphParser = new ParagraphParser(sentenceParser);
            Component component = new Composite(paragraphParser.handle(text, ComponentType.PARAGRAPH));
            component.setComponentType(ComponentType.DOCUMENT);
            log.debug("Document parsed: {} paragraphs",
                    component.getComponents().size());
            System.out.println("Recovered document: ");
            System.out.println(component.getValue());
            System.out.println("Symbol count excluding spaces: ");
            System.out.println(component.getSize());
            DocumentService documentService = new DocumentService();
            System.out.println("Maximum count of sentences with common word: " + documentService.findSentencesWithMatchesCount(component));
            char symbol = 'a';
            System.out.println("ascending sort by character " + symbol + " count in each sentence: ");
            documentService.sortSentencesByCharCount(component, symbol);
            System.out.println("Swapping the first and last lexemes in each sentence:");
            documentService.swapFirstAndLastLexemes(component);
            System.out.println(component.getValue());
        } catch (FileException e) {
            log.error("Reading file '{}' error!", filePath, e);
        } catch (Exception e) {
            log.error("Unexpected error!", e);
        }
    }
}
