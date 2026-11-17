package com.example.composite.service.impl;

import com.example.composite.comparator.ComponentComparator;
import com.example.composite.component.Component;
import com.example.composite.componentType.ComponentType;
import com.example.composite.service.Service;

import java.util.*;
import java.util.stream.Collectors;

public class DocumentService implements Service {

    @Override
    public long findSentencesWithMatchesCount(Component component) {
        ComponentType componentType = component.getComponentType();
        Map<Component, Long> map = new HashMap<>();
        if (componentType == ComponentType.DOCUMENT) {
            List<Component> sentences = component.getComponents().stream().flatMap(e -> e.getComponents().stream()).toList();
            for (Component components : sentences) {
                Set<Component> wordsSet = components.getComponents().stream().flatMap(lexeme -> lexeme.getComponents().stream().filter(e -> e.getComponentType() == ComponentType.WORD)).collect(Collectors.toSet());
                wordsSet.forEach(e -> map.merge(e, 1L, Long::sum));
            }
        }
        return map.values().stream().max(Long::compare).orElse(0L);
    }

    @Override
    public void sortSentencesByCharCount(Component component, char c) {
        List<String> list = new ArrayList<>();
        ComponentType componentType = component.getComponentType();
        if (componentType == ComponentType.DOCUMENT) {
            List<String> sentencesList = new ArrayList<>();
            for (Component paragraph : component.getComponents()) {
                for (Component sentence : paragraph.getComponents()) {
                    sentencesList.add(sentence.getValue());
                }
            }
            ComponentComparator comparator = new ComponentComparator(c);
            list.addAll(sentencesList);
            list.sort(comparator);
        }
        list.forEach(System.out::println);
    }

    @Override
    public void swapFirstAndLastLexemes(Component component) {
        ComponentType componentType = component.getComponentType();
        if (componentType == ComponentType.DOCUMENT) {
            for (Component paragraph : component.getComponents()) {
                for (Component sentence : paragraph.getComponents()) {
                    List<Component> list = sentence.getComponents();
                    Component firstLexeme = list.getFirst();
                    Component lastLexeme = list.getLast();
                    list.set(0, lastLexeme);
                    list.set(list.size() - 1, firstLexeme);
                }
            }
        }
    }
}
