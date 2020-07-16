package com.belsoft.generics.generic_methods;

import com.belsoft.generics.comparable_interface.User;

import java.util.List;

public class Utils {

    public static <T> String sum(T first, T second) {
        return first.toString() + second.toString();
    }

    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(String.format("Key = %1$s, Value = %2$s", key, value));
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    // class CAP#1 extends Pet {}
    // class Dog extends Pet {}
    public static void printPets(List<? extends Pet> pets) {

        // item is of type Pet
        var item = pets.get(0);
        Pet pet = pets.get(0);
        System.out.println(pets);

        // with the "extends" can only read but can not write to this List<? extends Pet>
        // because we need a new instance of anonymous class "capture of ? extends Pet"
        // error
        // Required type: capture of ? extends Pet
        // Provided: Pet
        // pets.add(new Pet("Name"));
    }

    // class CAP#1 extends Object {}
    // in this example Object is the parent of Pet
    // class Dog extends Pet {}
    public static void printPetsReadWrite(List<? super Pet> pets) {

        pets.add(new Pet("Name1"));
        pets.add(new Dog("Bolt"));
//        pets.add(new Object());


        // with the "super" can write but can not read this List<? super Pet>
        // Pet pet = pets.get(0);

        // item is of type Object
        var item = pets.get(0);

        Object object = pets.get(0);
        System.out.println(pets);

        // Unsafe cast !!!
        //Pet pet = (Pet)pets.get(0);
    }
}
