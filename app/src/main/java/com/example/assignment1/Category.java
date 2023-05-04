package com.example.assignment1;
import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.List;

public class Category {
    private String name;
    private Drawable shape;
    private List<Item> itemList;
    private boolean isExpanded;

    public Category(String name, Drawable shape, List<Item> items) {
        this.name = name;
        this.shape = shape;
        this.itemList = items;
        this.isExpanded = false; // initially set to false in order to make items inside this category invisible
    }

    public String getName() {
        return name;
    }

    public Drawable getShape() {
        return shape;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
