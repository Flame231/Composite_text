package com.example.composite.parser.impl;

import com.example.composite.parser.Parser;

public class LexemeParser extends Parser {

    private static final String LEXEME_REGEX = "[^\\s]+";

    public LexemeParser(Parser nextParser) {

        super(LEXEME_REGEX, nextParser);
    }
}
