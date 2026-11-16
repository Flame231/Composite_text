package org.example.component.impl;

import org.example.component.Component;
import org.example.componentType.ComponentType;

import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    public ComponentType componentType;
    private final List<Component> components;

    public Composite(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String getValue() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.getValue());
            stringBuilder.append(component.getComponentType().getDelimiter());
        }
        return stringBuilder.toString();
    }

    @Override
    public long getSize() {
        return components.stream().map(Component::getSize).reduce(0L, Long::sum);

    }

    @Override
    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }
}
