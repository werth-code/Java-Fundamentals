package com.werth;

import java.util.ArrayList;
import java.util.List;

public class FourPrinciplesOOP implements AbstractionExample {
    private String name;
    private List<String> names;

    public FourPrinciplesOOP(String name) {
        this.name = name;
    }

    public FourPrinciplesOOP() {
        this.names = new ArrayList<>();
        this.names.add("Hope");
        this.names.add("Mike");
        this.names.add("Trish");
    }

    @Override
    public void speak() {
        if(this.name == null) System.out.println(names.get(0) + " Say's Hello!");
        else System.out.println(this.name + " Say's Hello!");
    }

    public List<String> getNames() {
        return names;
    }

    //Abstraction
    /*
    An example would be the Java Collections Framework. It provides us with data structures and methods
    which we can invoke on the contents of those structures - we can create an ArrayList with a single line
    of code because the mechanics and implementation has been hidden within many classes and interfaces.
     */


    //Polymorphism
    /*
    An example would be method overloading, where you have two methods which accept different parameters. Also method
    @Override when you override an existing method - the ability of your code to change depending on the context in which
    it is being used.
    */

    //Inheritance
    /*

    */

    //Encapsulation



}
