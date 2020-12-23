package com.werth;

import solid.ChildrensBook;
import solid.Ebook;

public class Main {

    public static void main(String[] args) {
        //CHECK OUT EACH CLASS FOR ADDITIONAL EXAMPLES AND COMMENTARY.
        Main.fourPrinciplesOOP();

        Main.accessModifiers();

        Main.solidPrinciples();

    }

    public static void fourPrinciplesOOP() {
        // We create a new FourPrinciplesOOP object and call speak() which is an abstract method implemented from the Abstraction Interface.
        System.out.println("---ABSTRACTION & POLYMORPHISM---");
        FourPrinciplesOOP fourPrinciplesOOP = new FourPrinciplesOOP("Matt");
        fourPrinciplesOOP.speak();

        // This is an example of Polymorphism - We have two constructors, one which accepts a name and one that does not.
        FourPrinciplesOOP fourPrinciplesOOP2 = new FourPrinciplesOOP();
        fourPrinciplesOOP2.speak();

        System.out.println("\n---INHERITANCE---");
        // Inheritance - here our child class inherits the toString function that we have @Override in our Parent class.
        Parent parent = new Parent("Joanna");
        System.out.println(parent.toString());

        // The Child class has inherited our new implementation of toString();
        Child child = new Child("Greg");
        System.out.println(child.toString());

        System.out.println("\n---ENCAPSULATION---");
        // Encapsulation - We made our name a Private variable. Using a getter method we can retrieve it.
        fourPrinciplesOOP2.getNames().forEach(System.out::println);
    }

    public static void accessModifiers() {
//        Public: Class, Package, Subclass, Global, Variable
//        Protected: Class, Package, Subclass
//        Default: Class, Package
//        Private: Class, Variable
        System.out.println("\n---ACCESS MODIFIERS---");
        System.out.println("'public' is used within this method - can be accessed by all classes, subclasses, and packages");
        System.out.println("'protected' can be accessed by all classes within its package & by subclasses in other packages");
        System.out.println("'default  or package private' can be accessed by all classes within it's package");
        System.out.println("'private' is only accessible by its own class");

    }

    public static void solidPrinciples() {
        //Single Responsibility
        //Open/Close Principle
        //Liskov's Substitution Principle
        //Interface Segregation Principle
        //Dependency Inversion
        System.out.println("\n---SOLID PRINCIPLES---");
        System.out.println("SOLID helps us to design better more sustainable code, so others can build upon our work in the future \n");

        System.out.println("---Single Responsibility---");
        ChildrensBook book = new ChildrensBook("Snakes for Kids: A Junior Scientist's Guide to Venom, Scales, and Life in the Wild", "Take an amazing journey into the wonderful world of snakes―fangs, rattles, and scales!\n",
                 "Michael G. Starkey");
        System.out.println("- We Created A Class For Book, ChildrensBook and a static Read method. Here we separated read() from Book so that it can take any type of Book.");
        book.read();

        System.out.println("---Open/Closed---");
        System.out.println("- Let's say we finished our Book class and have a working program. Now we want to add an 'hasEbook' variable.\n" +
                "instead of adding to our existing class - we should make a new implementation that extends our book class.\nClasses should be open for extension but closed for modification");

        Ebook ebook = new Ebook("Hello World", "A book about my journey through the world.", "Amanda Michaels");
        System.out.println("- Is this an Ebook? " + ebook.getHasEbook());
        ebook.read();

        System.out.println("\n---Liscov Substitution---");
        System.out.println("If class A is a subtype of class B, then we should be able to replace B with A without disrupting the behavior of our program.");
        System.out.println("Here we can call the getAuthor() from Ebook and Childrens Book because they are subtypes of Book");
        System.out.println(book.getAuthor() + " --- " + ebook.getAuthor());

        System.out.println("\n---Interface Segregation---");
        System.out.println("We should make multiple small interfaces instead of one large interface. This way, classes only need to implement necessary methods");


    }

}
