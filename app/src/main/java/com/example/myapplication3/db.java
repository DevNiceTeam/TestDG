package com.example.myapplication3;

import android.text.Editable;

import java.util.ArrayList;

class db extends ArrayList<db> {
    private String name;
    private String description;

    public db(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString()
    {
        return new StringBuilder()
                .append("Name: ").append(name).append(",")
                .append("number: ").append(description).append(",")
                .toString();
    }
}