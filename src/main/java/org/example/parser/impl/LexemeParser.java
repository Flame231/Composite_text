package org.example.parser.impl;

import org.example.parser.Parser;

public class LexemeParser extends Parser {
    public LexemeParser(Parser nextParser) {

        super("[^\\s]+", nextParser);
    }
}
