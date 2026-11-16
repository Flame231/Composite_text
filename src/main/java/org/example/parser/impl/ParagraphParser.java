package org.example.parser.impl;

import org.example.parser.Parser;

public class ParagraphParser extends Parser {

    public ParagraphParser(Parser nextParser) {
        super(".+\\R?", nextParser);
    }


}
