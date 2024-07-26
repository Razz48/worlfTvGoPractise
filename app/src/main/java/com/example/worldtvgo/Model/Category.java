package com.example.worldtvgo.Model;

import java.util.List;

public class Category {

    private final String name;
    private final List<InnerItem> items;

    public Category(String name, List<InnerItem> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<InnerItem> getItems() {
        return items;
    }
}
