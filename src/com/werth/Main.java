package com.werth;

import abstractclass.Forest;
import abstractclass.Tree;
import solid.*;

import java.util.Map;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        //CHECK OUT EACH CLASS FOR ADDITIONAL EXAMPLES AND COMMENTARY.
        Main.fourPrinciplesOOP();

        Main.accessModifiers();

        Main.solidPrinciples();

        Main.overloadingVsOverriding();

        Main.abstractClassVsInterface();

        Main.collectionVsCollections();

        Main.arrayStoreException();

        Main.JvmJdkJre();

        Main.whatIsHashMap();

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

        System.out.println("-Single Responsibility-");
        ChildrensBook book = new ChildrensBook("Snakes for Kids: A Junior Scientist's Guide to Venom, Scales, and Life in the Wild", "Take an amazing journey into the wonderful world of snakes―fangs, rattles, and scales!\n",
                 "Michael G. Starkey");
        System.out.println("- We Created A Class For Book, ChildrensBook and a static Read method. Here we separated read() from Book so that it can take any type of Book.");
        book.read();

        System.out.println("-Open/Closed-");
        System.out.println("- Let's say we finished our Book class and have a working program. Now we want to add an 'hasEbook' variable.\n" +
                "instead of adding to our existing class - we should make a new implementation that extends our book class.\nClasses should be open for extension but closed for modification");

        Ebook ebook = new Ebook("Hello World", "A book about my journey through the world.", "Amanda Michaels");
        System.out.println("- Is this an Ebook? " + ebook.getHasEbook());
        ebook.read();

        System.out.println("\n-Liscov Substitution-");
        System.out.println("If class A is a subtype of class B, then we should be able to replace B with A without disrupting the behavior of our program.");
        System.out.println("Here we can call the getAuthor() from Ebook and Childrens Book because they are subtypes of Book");
        System.out.println(book.getAuthor() + " --- " + ebook.getAuthor());

        System.out.println("\n-Interface Segregation-");
        System.out.println("We should make multiple small interfaces instead of one large interface. This way our classes only need to implement necessary methods");
        System.out.println("...Combining Multiple Smaller Interfaces...");
        System.out.println("'" + book.getBookName() + "'" +  " contains " + book.countWords() + " words.");
        System.out.println("Words Used " + book.wordUse().toString());


        System.out.println("\n-Dependency Inversion-");
        System.out.println("Depend on abstraction. Instead of using concrete implementations, whenever possible use implements over extends. So, if you are building a payment\n" +
                "system - and you need to communicate with an API - it would be best to have an interface which contains all of the functions needed to process payments." +
                "kind of like a middle-man. This way, if you want to switch processors, all you have to do is update your interface.");
        Book book1 = new Book("Ready Player Two", "blah blah blah", "Ernest Cline");
        Book book2 = new Book("A Promised Land", "A Promised Land is a memoir by Barack Obama, 44th President of the United States from 2009 to 2017.", "Barack Obama");
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book);
        LibraryMethods.printLibrary(library);
    }

    public static void overloadingVsOverriding() {
        System.out.println("\n---@OVERRIDE VS OVERLOADING---");
        System.out.println("- We overload a method by creating multiple versions that accept different parameters. We use this in the FourPrinciplesOOP Class to allow\n" +
                "one constructor to create a default setting.");
        System.out.println("@Override is what we use to adapt a method which we implement from an interface, so that it can work with our Class. We do this with toString in our Parent class.");
    }

    public static void abstractClassVsInterface() {
        System.out.println("\n---ABSTRACT CLASS VS INTERFACE ---");
        System.out.println("A class can only extend or inherit from one other class, however it can implement many different interfaces.");

        Forest forest = new Forest();
        Tree tree1 = new Tree(1, "Evergreen", true);
        Tree tree2 = new Tree(3, "Apple", true);
        forest.addSingleTree(tree1);
        forest.addSingleTree(tree2);

        System.out.println("-Here we create an abstract class TreeGroup, then extend that class through Forest. Forest now has access to all methods. Here are our tress in this Forest instance.\n");
        forest.getTrees().forEach(tree -> System.out.println(tree.returnAllTreeInfo()));

        System.out.println("-An interface only has the methods we create within it. If we use Interface Segregation (the I from SOLID), we can implement specific to what we need!\n" +
                "-Here we create two trees using forest.createSetOfTrees() from our TreeActions Interface, implemented by Forest.\n");
        forest.createSetOfTrees(2, 3, "Lemon", true).forEach(tree -> System.out.println(tree.returnAllTreeInfo()));
        }

    public static void collectionVsCollections() {
        System.out.println("\n--- COLLECTION VS COLLECTIONS ---");
        System.out.println("Collection is an interface containing the methods that we can use with collections such as .contains() on an ArrayList.");

        Forest forest = new Forest();
        Tree tree1 = new Tree(1, "Evergreen", true);
        forest.addSingleTree(tree1);
        System.out.println("-If we create a new ArrayList through our forest class -> Forest forest = new Forest() -> then forest.add(tree1)");
        System.out.println("Then call forest.getTrees.contains(tree1) we get.. " + forest.getTrees().contains(tree1));
        System.out.println("Here the ArrayList is part of the Java Collections Framework, and the methods .add() and .contains() are part of the Collection Interface.");
    }

    public static void arrayStoreException() {
        System.out.println("\n--- ArrayStoreException ---");
        System.out.println("An ArrayStoreException occurs when we try to pass in the wrong data type to an array, it is unchecked, meaning that it is caught at runtime.");
        Forest forest = new Forest();
        //forest.addSingleTree("string");
    }

    public static void JvmJdkJre() {
        System.out.println("\n--- JVM - JDK - JRE ---");
        System.out.println("-JVM is Java Virtual Machine, provides the environment for Java to run.");
        System.out.println("-JDK is Java Development Kit, the tools to compile, document and package Java programs. A Software Dev Kit.");
        System.out.println("-JRE is Java Runtime Environment, a subset of JDK to share ones runtime environment. Includes core classes.");
    }

    public static void whatIsHashMap() {
        System.out.println("\n--- HASHMAP ---");
        Book aBook = new Book("Java in a Nutshell", "With more than 700,000 copies sold to date, Java in a Nutshell from O'Reilly is clearly the favorite resource amongst the legion of developers and programmers using Java technology. And now, with the release of the 5.0 version of Java, O'Reilly has given the book that defined the \"in a Nutshell\" category another impressive tune-up.\n" +
                "\n" +
                "In this latest revision, readers will find Java in a Nutshell, 5th Edition, does more than just cover the extensive changes implicit in 5.0, the newest version of Java. It's undergone a complete makeover--in scope, size, and type of coverage--in order to more closely meet the needs of the modern Java programmer.\n", "David Flanagan");

        System.out.println("-We create a new book with " + aBook.countWords() + " words.");
        System.out.println("-We map each word as a KEY and how many times each word appears as our VALUE");
        Map<String, Long> mapWords = aBook.wordUse();
        System.out.println(mapWords);
        System.out.println("-HashMaps have an average O(1) constant insertion/lookup time, but are unordered and require the KEY to retrieve VALUES.");
        System.out.println("-However, if we do NOT know the key, it takes O(n) time to loop through each key and find our value.");

        String mostFreqWord = mapWords.entrySet().stream().max((a, b) -> a.getValue() > b.getValue() ? 1 : -1).get().getKey();

        System.out.println("Word which appears the most -> '" + mostFreqWord +"' appears " +mapWords.get(mostFreqWord) + " times.");
    }


}
