package org.example.parser.impl;

import org.example.component.Component;
import org.example.componentType.ComponentType;
import org.example.component.impl.Leaf;
import org.example.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolParser extends Parser {

    public SymbolParser() {
        super(".", null);
    }

    @Override
    public List<Component> handle(String string, ComponentType componentType) {
        Pattern pattern = Pattern.compile(super.regex);
        Matcher matcher = pattern.matcher(string);
        List<Component> s = new ArrayList<>();
        if (matcher.find()) {
            do {
                String match = matcher.group();
               Component component = new Leaf(match);
               component.setComponentType(componentType);
                s.add(component);
            }
            while (matcher.find());
        }
        return s;
    }
}
