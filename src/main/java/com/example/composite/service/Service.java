package com.example.composite.service;

import com.example.composite.component.Component;

public interface Service {
    
    long findSentencesWithMatchesCount(Component component);

    void sortSentencesByCharCount(Component component, char c);

    void swapFirstAndLastLexemes(Component component);
}
