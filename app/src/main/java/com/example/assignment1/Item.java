package com.example.assignment1;
public class Item {
    private String name;
    private String rule;
    private int shape;

    public Item(String name, String rule, int shape) {
        this.name = name;
        this.rule = rule;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }
    public String getRule() {
        return rule;
    }
    public int getShape() {
        return shape;
    }
}
