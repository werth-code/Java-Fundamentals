package com.werth;

import java.util.List;

public class Parent {
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inherited toString() '" + name + '\'';
    }
}
