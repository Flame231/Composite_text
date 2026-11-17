package com.example.composite.parser.impl;

import com.example.composite.parser.Parser;

public class SentenceParser extends Parser {

    private static final String SENTENCE_REGEX = ".+?[.?!]+";

    public SentenceParser(Parser nextParser) {
        super(SENTENCE_REGEX, nextParser);
    }
}
