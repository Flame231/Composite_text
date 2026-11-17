package com.example.composite.parser.impl;

import com.example.composite.component.Component;
import com.example.composite.componentType.ComponentType;
import com.example.composite.component.impl.Leaf;
import com.example.composite.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolParser extends Parser {

    private static final String SYMBOL_REGEX = ".";

    public SymbolParser() {
        super(SYMBOL_REGEX, null);
    }

    @Override
    public List<Component> handle(String string, ComponentType componentType) {
        Pattern pattern = Pattern.compile(super.regex);
        Matcher matcher = pattern.matcher(string);
        List<Component> components = new ArrayList<>();
        if (matcher.find()) {
            do {
                String match = matcher.group();
                Component component = new Leaf(match);
                component.setComponentType(componentType);
                components.add(component);
            }
            while (matcher.find());
        }
        return components;
    }
}
