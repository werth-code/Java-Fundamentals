package com.werth;

public interface AbstractionExample {
    default void speak(String name){
        System.out.println(name + " Say's Hello!");
    }
}
