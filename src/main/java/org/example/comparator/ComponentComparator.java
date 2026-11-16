package org.example.comparator;

import java.util.Comparator;

public class ComponentComparator implements Comparator<String> {

    private final char symbol;

    public ComponentComparator(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(String o1, String o2) {
        long count1 = o1.chars().filter(e -> e == symbol).count();
        long count2 = o2.chars().filter(e -> e == symbol).count();
        return count1 > count2 ? 1 : (count1 < count2 ? -1 : 0);
    }
}
