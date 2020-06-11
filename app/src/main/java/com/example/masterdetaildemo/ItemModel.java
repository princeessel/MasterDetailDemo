package com.example.masterdetaildemo;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemModel implements Serializable {
    private String title;
    private String body;

    public ItemModel(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public ItemModel() {

    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @NonNull
    @Override
    public String toString() {
        return getTitle();
    }

    public static ArrayList<ItemModel> getItems() {
        ArrayList<ItemModel> itemModels = new ArrayList<>();
        itemModels.add(new ItemModel("Love Book", "This is the best love book"));
        itemModels.add(new ItemModel("Java Source Code", "Learn Java the easiest way"));
        itemModels.add(new ItemModel("The Computer", "This is the latest notebook computer"));
        itemModels.add(new ItemModel("The Magical Beast Novel", "This is the Magical Beast Novel"));
        return itemModels;
    }
}
