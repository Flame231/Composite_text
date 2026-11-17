package com.example.composite.parser;

import com.example.composite.component.Component;
import com.example.composite.componentType.ComponentType;
import com.example.composite.component.impl.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser {
    protected final String regex;
    protected final Parser nextParser;

    public Parser(String regex, Parser nextParser) {
        this.regex = regex;
        this.nextParser = nextParser;
    }

    public List<Component> handle(String string, ComponentType componentType) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        List<Component> components = new ArrayList<>();
        if (matcher.find()) {
            do {
                String match = matcher.group();
                List<Component> list = nextParser.handle(match, componentType.next());
                Component component = new Composite(list);
                component.setComponentType(componentType);
                components.add(component);
            }
            while (matcher.find());
        } else
        {
            return nextParser.handle(string, componentType.next());
        }
        return components;
    }
}
