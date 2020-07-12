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

        System.out.println(set);

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
        System.out.println("set1 : " + set1);
        System.out.println("set2 : " + set2);

        // Union
        set1.addAll(set2);
        System.out.println("Union : " + set1);

        // Intersection
        set1.retainAll(set2);
        System.out.println("Intersection : " + set1);

        // Difference
        set1.removeAll(set2);
        System.out.println("Difference : " + set1);
    }
}
