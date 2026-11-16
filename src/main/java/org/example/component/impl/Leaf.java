package org.example.component.impl;

import org.example.component.Component;
import org.example.componentType.ComponentType;

public class Leaf implements Component {
    private ComponentType componentType = ComponentType.SYMBOL;
    private final String lexeme;

    public Leaf(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String getValue() {
        return lexeme;
    }

    @Override
    public long getSize() {
        return 1;
    }

    @Override
    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }
}
