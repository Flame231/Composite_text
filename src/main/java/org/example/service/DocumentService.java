package org.example.service;

import org.example.comparator.ComponentComparator;
import org.example.component.Component;
import org.example.componentType.ComponentType;
import org.example.service.impl.Service;

import java.util.*;

public class DocumentService implements Service {

    @Override
    public long findSentencesWithMatchesCount(Component component) {
        ComponentType componentType = component.getComponentType();
        long count = 0;
        if (componentType == ComponentType.DOCUMENT) {
            for (Component paragraph : component.getComponents()) {

                for (Component sentence : paragraph.getComponents()) {
                    List<Component> components = new ArrayList<>();
                    for (Component lexeme : sentence.getComponents()) {
                        List<Component> words = lexeme.getComponents().stream().filter((e) -> e.getComponentType() == ComponentType.WORD).toList();
                        components.addAll(words);
                    }
                    outerLoop:
                    for (int i = 0; i < components.size(); i++) {
                        for (int j = i + 1; j < components.size(); j++) {
                            String word1 = components.get(i).getValue().toLowerCase();
                            String word2 = components.get(j).getValue().toLowerCase();
                            if (word1.equals(word2)) {
                                count++;
                                break outerLoop;
                            }
                        }
                    }
                }
            }
        }
        return count;
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
                    Component component1 = list.getFirst();
                    Component component2 = list.getLast();
                    list.set(0, component2);
                    list.set(list.size() - 1, component1);
                }
            }
        }
    }
}
