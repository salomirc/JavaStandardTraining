package com.belsoft.collections.set_interface;

import java.lang.reflect.Array;
import java.util.*;

public class SetDemo {
    public static void show() {
        Set<String> set = new HashSet<>();
        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");

        System.out.println("Printing the set");
        System.out.println(set);
        System.out.println("The order of elements is not guaranteed !\n");

        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c", "d", "d");
        System.out.println(collection);

        // remove duplicates from a collection in one line of codes
        Set<String> mySet = new HashSet<>(collection);
        System.out.println(mySet);
        System.out.println();

        // Arrays.asList("a", "b", "c") in place of new ArrayList<>(); add() ...
        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("b", "c", "d"));
        System.out.println("setA : " + set1);
        System.out.println("setB : " + set2);

        // Union
        var setA = new HashSet<>(set1);
        var setB = new HashSet<>(set2);
        setA.addAll(setB);
        System.out.println("Union : " + setA);

        // Intersection
        setA = new HashSet<>(set1);
        setB = new HashSet<>(set2);
        setA.retainAll(setB);
        System.out.println("Intersection : " + setA);

        // Difference
        setA = new HashSet<>(set1);
        setB = new HashSet<>(set2);
        setA.removeAll(setB);
        System.out.println("Difference A - B : " + setA);
    }
}
