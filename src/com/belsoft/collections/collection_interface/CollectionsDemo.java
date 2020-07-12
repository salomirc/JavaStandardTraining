package com.belsoft.collections.collection_interface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();
//        collection.add("a");
//        collection.add("b");
//        collection.add("c");

        Collections.addAll(collection, "a", "b", "c");

        for (var item : collection) {
            System.out.println(item);
        }

        collection.remove("a");
        System.out.println(collection);
        System.out.println(collection.size());
        System.out.println(collection.contains("a"));
        System.out.println(collection.contains("b"));

        // remove all items in the collection
        collection.clear();
        System.out.println(collection);
        System.out.println(collection.isEmpty());

        Collections.addAll(collection, "a", "b", "c");

        // toArray() -> Object[]
        Object[] objectArray = collection.toArray();

        // toArray(new String[0] -> String[] with enough capacity for our colletion
        // 0 is a convention for enough capacity
        String[] stringArray = collection.toArray(new String[0]);

        // other.addAll(collection);
        Collection<String> other = new ArrayList<>(collection);

        // compare by reference
        System.out.println(collection == other); // false

        // compare by values
        System.out.println(collection.equals(other)); // true
    }
}
