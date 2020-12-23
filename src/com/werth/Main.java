package com.werth;

public class Main {

    public static void main(String[] args) {


        // We create a new FourPrinciplesOOP object and call speak() which is an abstract method implemented from the Abstraction Interface.
        FourPrinciplesOOP fourPrinciplesOOP = new FourPrinciplesOOP("Matt");
        fourPrinciplesOOP.speak();

        // This is an example of Polymorphism - We have two constructors, one which accepts a name and one that does not.
        FourPrinciplesOOP fourPrinciplesOOP2 = new FourPrinciplesOOP();
        fourPrinciplesOOP.speak();

    }
}
