package com.werth;

import abstractclass.Forest;
import abstractclass.Tree;
import generics.GenericsExample;
import solid.*;

import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        //CHECK OUT EACH CLASS FOR ADDITIONAL EXAMPLES AND COMMENTARY.


        fourPrinciplesOOP();

        accessModifiers();

        solidPrinciples();

        overloadingVsOverriding();

        abstractClassVsInterface();

        collectionVsCollections();

        arrayStoreException();

        JvmJdkJre();

        whatIsHashMap();

        comparableComparator();

        classLoaders();

        finalFinallyFinalize();

        dictionary();

        whichCollectionIsFaster();

        instanceVariables();

        finalizeMethod();

        accessModifiers();

        abstractClass();

        abstractMethods();

        whatIsAPI();

        whatIsAutoboxing();

        classVariables();

        classPath();

        DOM();

        enumeratedType();

        garbageCollection();

        generics();

        JAR();

        dynamicJava();

        multithreaded();

        whatIsProtected();

        serialization();

        //exceptionKeywords();
    }

    public static void fourPrinciplesOOP() {
        // We create a new FourPrinciplesOOP object and call speak() which is an abstract method implemented from the Abstraction Interface.
        System.out.println("---ABSTRACTION & POLYMORPHISM---");
        System.out.println("We use a method overload on the FourPrinciplesOOP class to show how we can use polymorphism to make our code more dynamic.");
        System.out.println("Our class is able to abstract our code so that we are able to create instances easily.");
        FourPrinciplesOOP fourPrinciplesOOP = new FourPrinciplesOOP("Matt");
        fourPrinciplesOOP.speak();

        // This is an example of Polymorphism - We have two constructors, one which accepts a name and one that does not.
        FourPrinciplesOOP fourPrinciplesOOP2 = new FourPrinciplesOOP();
        fourPrinciplesOOP2.speak();

        System.out.println("\n---INHERITANCE---");
        System.out.println("Inheritance - here our child class inherits the toString function that we have @Override in our Parent class.");
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
                "instead of adding to our existing class - we should make a new implementation instead of altering our working code.\nClasses should be open for extension but closed for modification");

        Ebook ebook = new Ebook("Hello World", "A book about my journey through the world.", "Amanda Michaels");
        System.out.println("- Is this an Ebook? " + ebook.getHasEbook());
        ebook.read();

        System.out.println("\n-Liscov Substitution-");
        System.out.println("If class A is a subtype of class B, then we should be able to replace B with A without disrupting the behavior of our program.");
        System.out.println("Here we can call the getAuthor() from Ebook and Childrens Book because they are subtypes of Book");
        System.out.println(book.getAuthor() + " --- " + ebook.getAuthor());
        System.out.println("You have a super that creates a method.. (view this method as a contract). A sub class extends the super and implements that method. \n" +
                        "Any @Overrides on that method should not fundamentally change the output. So you should be able to pass in to the @Override method -  \n" +
                        "an object made from the super without issue.");

        System.out.println("\n-Interface Segregation-");
        System.out.println("We should make multiple small interfaces instead of one large interface. This way our classes only need to implement necessary methods");
        System.out.println("...Combining Multiple Smaller Interfaces...");
        System.out.println("'" + book.getBookName() + "'" +  " contains " + book.countWords() + " words.");
        System.out.println("Words Used " + book.wordUse().toString());


        System.out.println("\n-Dependency Inversion-");
        System.out.println("Depend on abstraction. Instead of using concrete implementations, whenever possible use an intermediary.");
        System.out.println("If you are building an API that needs to connect to a bank, you would want to create an interface with your methods " +
                "in stead of hard coding to the bank. That way, if you wanted to switch banks - it would be simple.");

        System.out.println("An example would be --> List<String> strings = new ArrayList<>()");
        System.out.println("This way we can always change the type of List later like this --> = new LinkedList<>()");

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
        System.out.println("\n" + mapWords);
        System.out.println("\n-HashMaps have an average O(1) constant insertion/lookup time, but are unordered and require the KEY to retrieve VALUES.");
        System.out.println("-However, if we do NOT know the key, it takes O(n) time to loop through each key and find our value.");

        String mostFreqWord = mapWords.entrySet().stream().max((a, b) -> a.getValue() > b.getValue() ? 1 : -1).get().getKey();

        System.out.println("\nWord which appears the most -> '" + mostFreqWord + "' appears " + mapWords.get(mostFreqWord) + " times.");

        System.out.println("HashMap-uhs are not sorted numerically, but by a hashing function which optimizes their efficiency.");
    }

    public static void comparableComparator() {
        System.out.println("\n--- COMPARABLE VS COMPARATOR ---");
        System.out.println("Comparable is an interface with the compareTo() method. Comparator is an interface that has two methods compare() and equals()");
        System.out.println("If a class implements Comparable it can sort by comparing two objects of that class.");

        Book book1 = new Book("Ready Player Two", "blah blah blah", "Ernest Cline");
        Book book2 = new Book("A Promised Land", "A Promised Land is a memoir by Barack Obama, 44th President of the United States from 2009 to 2017.", "Barack Obama");
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        System.out.println("... Unsorted ...");
        library.getBooks().forEach(book -> System.out.println(book.getBookName()));
        library.getBooks().sort(Book::compareTo);
        System.out.println("... Sorted using sort(Book::compareTo) ...");
        library.getBooks().forEach(book -> System.out.println(book.getBookName()));
        System.out.println("... Does Book at index 0 .equal() Book at index 1 in Library? " + library.getBooks().get(0).equals(library.getBooks().get(1)));

    }


    public static void classLoaders() { //// TODO: 12/26/20 still incomprehensible.
        System.out.println("\n--- CLASS LOADERS ---");
        System.out.println("Class loaders load Java classes into memory during runtime to the JVM - ");

        System.out.println("Classloader of Main: "
                + Main.class.getClassLoader());
    }

    public static void func() {
        int zero = -1;
        try {
            if (zero < 0) {
                throw new IOException();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("We used TRY, our code failed so we THREW an exception." +
                    "\nWe used CATCH to catch the exception and now we use FINALLY to sout this message.");
        }
    }

    public static void exceptionKeywords() {
        System.out.println("\n--- EXCEPTION KEYWORDS ---");
        System.out.println("Try, Catch, Finally, Throw, Throws");
        System.out.println("A checked exception like IOException can be thrown from the method body but must be handled later. In this case we use 'throws TypeOfException' before the method body" +
                "\nand 'throw new TypeOfException() inside the method. THROWS is saying this method will throw an exception. THROW is when when we throw new TypeOfException()\n");
        System.out.println("When we want to handle the exception we use TRY, CATCH & FINALLY inside the method.");
        func();
    }

    public static void finalFinallyFinalize() {
        System.out.println("\n--- FINAL, FINALLY, FINALIZE ---");
        System.out.println("We use the keyword final to declare a class, method, variable unchangeable. Once it is set - it cannot be changed.\n" +
                "Finally is used to do one last thing after we throw an exception - allows our code to fail gracefully by wrapping things up and not immediately crashing.\n" +
                "Finalize helps us with garbage collection in Java.");

        final int one = 1;
        //one = 2;
        System.out.println(one + " Is final and cannot be changed to 2.");
    }

    public static void dictionary() {
        System.out.println("\n--- DICTIONARY ---");
        System.out.println("Dictionary is an abstract class used with Map types to add key, value pairs.");
        System.out.println("It has the methods put(), elements(), get(), isEmpty(), keys(), remove() and size().");

        Book aBook = new Book("Java in a Nutshell", "With more than 700,000 copies sold to date, Java in a Nutshell from O'Reilly is clearly the favorite resource amongst the legion of developers and programmers using Java technology. And now, with the release of the 5.0 version of Java, O'Reilly has given the book that defined the \"in a Nutshell\" category another impressive tune-up.\n" +
                "\n" +
                "In this latest revision, readers will find Java in a Nutshell, 5th Edition, does more than just cover the extensive changes implicit in 5.0, the newest version of Java. It's undergone a complete makeover--in scope, size, and type of coverage--in order to more closely meet the needs of the modern Java programmer.\n", "David Flanagan");

        Map<String, Long> map = aBook.wordUse();
        System.out.println("- Here we bring back our wordUse map.");
        System.out.println("map.get(0): " + map.get("programmers"));
        System.out.println("map.put('Thingamajig', 2L)): " + map.put("Thingamajig", 2L));
        System.out.println("map.isEmpty()): " + map.isEmpty());
        System.out.println("map.keySet(): " + map.keySet());
        System.out.println("map.remove('Thingamajig'): " + map.remove("Thingamajig"));
        System.out.println("map.size(): " + map.size());
    }


    public static void whichCollectionIsFaster() {
        System.out.println("\n--- WHICH COLLECTION IS FASTER ---");
        System.out.println("Each collection has a benefit and a trade off. For insertion/removal HashMaps offer O(1) constant time - faster than an ArrayList, but you\n" +
                "must know the key or value to add/remove. ArrayLists have ordered access and random access - you can find first, last elements quickly. HashSets do not allow" +
                "duplicate values.");

        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < 100000; i++) {
            intList.add(i);
        }

        HashMap<Integer, Integer> intMap = new HashMap<>();
        for(int i = 0; i < 100000; i++) {
            intMap.put(i, i);
        }

        HashSet<Integer> intHashSet = new HashSet<>();
        for(int i = 0; i < 100000; i++) {
            intHashSet.add(i);
        }

        final long startTimeAL = System.nanoTime();
        intList.indexOf(50000);
        final long endTimeAL = System.nanoTime();

        long totalTimeAL = endTimeAL- startTimeAL;

        final long startTimeHS = System.nanoTime();
        intHashSet.contains(50000);
        final long endTimeHS = System.nanoTime();

        long totalTimeHS = endTimeHS - startTimeHS;

        final long startTimeHM = System.nanoTime();
        intMap.get(50000);
        final long endTimeHM = System.nanoTime();

        long totalTimeHM = endTimeHM - startTimeHM;

        System.out.println("Total Time To Find Mid-Element indexOf() ArrayList 100000 Elements: " + totalTimeAL);
        System.out.println("Total Time To .get(50000) From HashMap Of 100000 Elements: " + totalTimeHM);
        System.out.println("Total Time To Check For Inclusion In HashSet .contains(50000) " + totalTimeHS);

        String fastMethod;
        long fastestTime;
        if(totalTimeHM < totalTimeHS && totalTimeHM < totalTimeAL) {
            fastMethod = "HashMap";
            fastestTime = totalTimeHM;
        }
        else if(totalTimeHS < totalTimeHM && totalTimeHS < totalTimeAL) {
            fastMethod = "HashSet";
            fastestTime = totalTimeHS;
        }
        else {
            fastMethod = "ArrayList";
            fastestTime = totalTimeAL;
        }
        System.out.println(fastMethod + " is the fastest in this example at " + fastestTime);
    }

    public static void instanceVariables() {
        System.out.println("\n---INSTANCE VARIABLES---");
        System.out.println("An instance variable is declared within a class and created when a class is instantiated. As an example: ");
        Ebook ebook = new Ebook("Wild World Of Oranges", "Oranges are incredible things..", "James Orangealot");
        System.out.println("The variables for String author and String bookName " + ebook.getAuthor() + " & " + ebook.getBookName());
        System.out.println("Are created as soon as we create a new instance of eBook.");
    }

    public static void finalizeMethod() {
        System.out.println("\n---FINALIZE METHOD---");
        System.out.println("The finalize() is invoked when the JVM no longer needs a particular instance. Once called the garbage collector runs.\n" +
                "It's main purpose is to free up resources and speed up your program.");

    }

    public static void abstractClass() {
        System.out.println("\n--- ABSTRACT CLASS ---");
        System.out.println("An Abstract Class is an un-instantiatable class which can be extended and it's methods passed by the extending class.");
        System.out.println("We used a treeGroup abstract class so that we could create different versions of treeGroups such as Forest & Orchard\n" +
                "which all have the basic implementation of treeGroup.");
    }

    public static void abstractMethods() {
        System.out.println("\n--- ABSTRACT METHODS ---");
        System.out.println("An Abstract Method is a method without implementation, which will be @override by the implementing class. Often used with interfaces.");
        System.out.println("Our Readable Interface is an example of this.");
    }

    public static void whatIsAPI() {
        System.out.println("\n--- API ---");
        System.out.println("Application Programming Interface API allows applications to communicate with each other. An example would be a weather API\n" +
                "which allows another application to download it's data, parse it and show it in a different way - perhaps combining it with data from another API.");
    }

    public static void whatIsAutoboxing() {
        System.out.println("\n--- Autoboxing ---");
        System.out.println("When the compiler converts wrapper classes and primitive types automatically.");

        int num = 2;
        Integer number = (Integer) num; //this cast/conversion becomes unnecessary.
        Integer number2 = num; //int is autoboxed into Integer by compiler.

        System.out.println("int num = " + num + "\nInteger number2 = num " + "\nnumber2 = " + number2 + " | " + number2.getClass());
    }

    public static void classVariables() {
        System.out.println("\n--- CLASS VARIABLES ---");
        System.out.println("Class Variables are static variables defined within a class. These values are set once and are the same for each instance of " +
                "that class.\nFor example - we have a static String variable in Ebook that defines type = 'PDF'. Now all instances of Ebook will have type = 'PDF'.");
        Ebook ebook = new Ebook("a", "b", "c");
        System.out.println("ebook.getType() = " + ebook.getType());
    }

    public static void classPath() {
        System.out.println("\n--- CLASSPATH ---");
        System.out.println("Classpath is a variable which tells applications and JDK where user created classes are located.");
        System.out.println("We use this with \nimport abstractclass.Forest;\n" +
                "import abstractclass.Tree;\n" +
                "import solid.*;");

        System.out.println("Later when we reference the classes, JVM knows where to look for them.");
    }

    public static void DOM() {
        System.out.println("\n--- DOM ---");
        System.out.println("DOM is Document Object Model a programming interface which is language agnostic - through it we are able to manipulate HTML/XML.");
    }

    public static void enumeratedType() {
        System.out.println("\n--- ENUM ---");
        System.out.println("ENUM or Enumerated type is a fixed, array like set of values created as a type of class.");
        System.out.println("Here we create an enum Genre. It's value can be stored in the genre variable on Book.");
        Book book = new Book("a", "b", "c");
        book.setGenre(Genre.SCIENCE_FICTION);
        System.out.println("This Book's Genre is : " + book.getGenre());
    }

    public static void garbageCollection() {
        System.out.println("\n--- GARBAGE COLLECTION ---");
        System.out.println("Garbage collection happens automatically in Java, and is the freeing up of memory that will no longer be needed in the program.");
    }

    public static void generics() {
        System.out.println("\n--- GENERICS ---");
        System.out.println("A Generic in Java can be used to allow the usage of multiple types <T>.  At compile time\n" +
                "Java will perform all needed checks - allowing us to use multiple types with our classes, interfaces or methods.");

        System.out.println("\nSome of the checks Java will perform - Type Safety - Is a guarantee that correct types will be accepted.");
        System.out.println("List<String> listStrings = new ArrayList<>();\n" +
                        "listStrings.add(5); Will NOT WORK because 5 is not a String. In this case the compiler will warn you.\n" +
                "but if we try listStrings('dog') it will be accepted.");


        System.out.println("\n- Type Erasure - Is when the compiler removes all type parameters <T> and replaces with ordinary classes.\n" +
                "To do this, Java may cast from one type to another or generate bridge methods.\n");

        GenericsExample<Integer> integerTest = new GenericsExample<>(10);
        GenericsExample<Double> doubleTest = new GenericsExample<>(10.0);
        GenericsExample<String> stringTest = new GenericsExample<>("Hello");
        System.out.println(integerTest + " - " + integerTest.getObj() + " - If we get our Integer value with getObj() then call .getClass() = " + integerTest.getObj().getClass());
        System.out.println(doubleTest + " - " + doubleTest.getObj() + " - If we get our Double value with getObj() then call .getClass() = " + doubleTest.getObj().getClass());
        System.out.println(stringTest + " - " + stringTest.getObj() + " - If we get our String value with getObj() then call .getClass() = " + stringTest.getObj().getClass());

        System.out.println("We use generics to give us incredible flexibility of type. It allows us to create more polymorphic and flexible code.");
    }

    public static void JAR() {
        System.out.println("\n--- JAR ---");
        System.out.println("JAR is Java Archive and it is a compressed file format which gathers many files into a single file.\n" +
                "Generally JAR is used with Java Applets, and can compress audio, image and class files together.");
    }

    public static void dynamicJava() {
        System.out.println("\n--- DYNAMIC JAVA ---");
        System.out.println("Java is considered a dynamic language because it can be platform independent, through it's use of Byte code - which can be written on one platform and used on another.\nClass files are also loaded at runtime.");

    }

    public static void multithreaded() {
        System.out.println("\n--- MULTITHREADED ---");
        System.out.println("Different parts of the code can execute concurrently to maximize CPU.");
        System.out.println("We can use multithreading by either extending the Thread class or implementing the Runnable interface.");
    }

    public static void whatIsProtected() {
        System.out.println("\n--- PROTECTED ---");
        System.out.println("'protected' is an access modifier - allows access by all classes within its package & by subclasses in other packages");
    }

    public static void serialization() {
        System.out.println("\n--- SERIALIZATION ---");
        System.out.println("Object Serialization is an object being created from incoming data. You can Serialize using ObjectInputStream and ObjectOutputStream");
        System.out.println("To Serialize a class you must implement the Serializable interface and all fields must be serializable.");

    }

}
