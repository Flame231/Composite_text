package com.example.composite.componentType;

public enum ComponentType {
    DOCUMENT(""),
    PARAGRAPH("\n"),
    SENTENCE(" "),
    LEXEME(" "),
    WORD(""),
    SYMBOL(""),
    PUNCTUATION("");

    private final String delimiter;

    ComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    private static final ComponentType[] VALUES = values();

    public ComponentType next() {
        int nextIndex = this.ordinal() + 1;
        if (nextIndex >= VALUES.length) {
            return this;
        }
        return VALUES[nextIndex];
    }
}
