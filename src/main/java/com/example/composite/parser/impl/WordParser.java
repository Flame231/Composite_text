package com.example.composite.parser.impl;

import com.example.composite.component.Component;
import com.example.composite.componentType.ComponentType;
import com.example.composite.component.impl.Composite;
import com.example.composite.component.impl.Leaf;
import com.example.composite.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parser {

    private static final String WORD_OR_PUNCTUATION_REGEX = "([^\\s\\p{P}]+)|(\\p{P})";

    public WordParser(Parser nextParser) {
        super(WORD_OR_PUNCTUATION_REGEX, nextParser);
    }

    @Override
    public List<Component> handle(String string, ComponentType componentType) {
        Pattern pattern1 = Pattern.compile(WORD_OR_PUNCTUATION_REGEX);
        Matcher matcher = pattern1.matcher(string);
        List<Component> components = new ArrayList<>();
        if (matcher.find()) {
            do {
                if (matcher.group(1) != null) {
                    String match = matcher.group(1);
                    List<Component> list = nextParser.handle(match, componentType.next());
                    Component component = new Composite(list);
                    component.setComponentType(componentType);
                    components.add(component);
                }
                else if ((matcher.group(2) != null)){
                    String match = matcher.group(2);
                    Component component = new Leaf(match);
                    component.setComponentType(ComponentType.PUNCTUATION);
                    components.add(component);
                }
            }
            while (matcher.find());
        }
        return components;
    }
}
