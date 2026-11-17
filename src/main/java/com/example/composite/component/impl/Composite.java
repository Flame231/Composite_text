package com.example.composite.component.impl;

import com.example.composite.component.Component;
import com.example.composite.componentType.ComponentType;

import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private ComponentType componentType;
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
        for (int i = 0; i < components.size(); i++) {
            stringBuilder.append(components.get(i).getValue());
            if (!(i == components.size() - 1)) {
                stringBuilder.append(components.get(i).getComponentType().getDelimiter());
            }
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        if (!(this.componentType == ((Composite) o).getComponentType())) {
            return false;
        }
        return this.getValue().toLowerCase().equals(((Composite) o).getValue().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentType, this.getValue().toLowerCase());
    }
}
