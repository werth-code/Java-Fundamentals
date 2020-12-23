package com.werth;

//Inheritance
    /*
        Notice how Child does not have the toString() method @Override implementation but can use it because it is inherited
        from Parent.
    */

public class Child extends Parent {
    public Child(String name) {
        super(name);
    }


}
