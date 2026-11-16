package org.example.service.impl;

import org.example.component.Component;

public interface Service {
    
    long findSentencesWithMatchesCount(Component component);

    void sortSentencesByCharCount(Component component, char c);

    void swapFirstAndLastLexemes(Component component);
}
