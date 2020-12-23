package com.werth;

import java.util.List;

//Inheritance
    /*
        Notice how Child does not have this toString() method @Override implementation but can use it because it is inherited
        from Parent.
    */

public class Parent {
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    //Polymorphism RUNTIME handled during runtime.
    @Override
    public String toString() {
        return "Inherited toString() '" + name + '\'';
    }

}
