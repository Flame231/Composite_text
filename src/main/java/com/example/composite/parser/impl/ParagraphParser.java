package com.example.composite.parser.impl;

import com.example.composite.parser.Parser;

public class ParagraphParser extends Parser {

    private static final String PARAGRAPH_REGEX = ".+\\R?";

    public ParagraphParser(Parser nextParser) {
        super(PARAGRAPH_REGEX, nextParser);
    }


}
