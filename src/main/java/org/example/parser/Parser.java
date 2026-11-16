package org.example.parser;

import org.example.component.Component;
import org.example.componentType.ComponentType;
import org.example.component.impl.Composite;

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
        List<Component> s = new ArrayList<>();
        if (matcher.find()) {
            do {
                String match = matcher.group();
                List<Component> list = nextParser.handle(match, componentType.next());
                Component component = new Composite(list);
                component.setComponentType(componentType);
                s.add(component);
            }
            while (matcher.find());
        } else {
            return nextParser.handle(string, componentType.next());
        }
        return s;
    }
}
