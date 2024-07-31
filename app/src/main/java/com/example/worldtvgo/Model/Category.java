package com.example.worldtvgo.Model;

import java.util.List;

public class Category {
    private String name;
    private List<Object> items; // List to store either InnerItem or GenreItem

    public Category(String name, List<Object> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }
}


