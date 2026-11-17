package com.example.composite.component.impl;

import com.example.composite.component.Component;
import com.example.composite.componentType.ComponentType;

public class Leaf implements Component {
    private ComponentType componentType = ComponentType.SYMBOL;
    private final String value;

    public Leaf(String value) {
        this.value = value;
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String getValue() {
        return value;
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
