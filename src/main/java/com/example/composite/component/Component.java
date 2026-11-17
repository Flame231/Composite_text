package com.example.composite.component;

import com.example.composite.componentType.ComponentType;

import java.util.List;

public interface Component {

    default List<Component> getComponents() {
        return List.of();
    }

    ComponentType getComponentType();

    String getValue();

    long getSize();

    void setComponentType(ComponentType componentType);
}
