package com.belsoft.collections.list_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void show() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(0, "!");
        System.out.println(list);

        list.clear();
        Collections.addAll(list, "a", "b", "c");
        System.out.println(list);
        System.out.println(list.get(0));

        // replace the element at index
        list.set(0, "a+");
        System.out.println(list);

        // remove the element at index
        list.remove(0);
        System.out.println(list);

        System.out.println(list.indexOf("b")); // 0 is index of the element
        System.out.println(list.indexOf("d")); // -1 if the element does not exist

        Collections.addAll(list, "a", "a");
        System.out.println(list);
        System.out.println(list.lastIndexOf("a")); // the index of the last "a" occurrence is 3

        System.out.println(list);
        System.out.println(list.subList(0, 2)); // fromIndex is inclusive, toIndex is exclusive
    }
}
