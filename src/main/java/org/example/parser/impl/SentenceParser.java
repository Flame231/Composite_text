package org.example.parser.impl;

import org.example.parser.Parser;

public class SentenceParser extends Parser {
    public SentenceParser(Parser nextParser) {
        super(".+?[.?!]", nextParser);
    }
}
