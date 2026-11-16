package org.example.component;

import org.example.componentType.ComponentType;

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
