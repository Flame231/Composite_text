package org.example.parser.impl;

import org.example.component.Component;
import org.example.componentType.ComponentType;
import org.example.component.impl.Composite;
import org.example.component.impl.Leaf;
import org.example.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parser {
    public WordParser(Parser nextParser) {
        super("([^\\s\\p{P}]+)|(\\p{P})", nextParser);
    }

    @Override
    public List<Component> handle(String string, ComponentType componentType) {
        Pattern pattern1 = Pattern.compile(regex);
        Matcher matcher = pattern1.matcher(string);
        List<Component> s = new ArrayList<>();
        if (matcher.find()) {
            do {
                if (matcher.group(1) != null) {
                    String match = matcher.group(1);
                    List<Component> list = nextParser.handle(match, componentType.next());
                    Component component = new Composite(list);
                    component.setComponentType(componentType);
                    s.add(component);
                }
                else if ((matcher.group(2) != null)){
                    String match = matcher.group(2);
                    Component component = new Leaf(match);
                    component.setComponentType(ComponentType.PUNCTUATION);
                    s.add(component);
                }
            }
            while (matcher.find());
        }
        return s;
    }
}
