package com.belsoft.lambdas.consumer_interface;

import java.util.List;
import java.util.function.Consumer;

public class LambdasDemo {
    public static void show() {
        List<Integer> list = List.of(1, 2, 3);

        // Imperative Programming (for, if/else, switch/case)
        for (var item : list) {
            System.out.println(item);
        }
        System.out.println();

        // Declarative Programming
        list.forEach(item -> System.out.println(item));
        System.out.println();


        List<String> stringList = List.of("a", "b", "c");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        stringList.forEach(print.andThen(printUpperCase).andThen(print));
    }
}
