package com.belsoft.lambdas.function_interface;

import java.util.function.Function;

public class LambdasDemo {
    public static void show() {
        Function<String, Integer> map = str -> str.length();
        var length = map.apply("Sky");
        System.out.println(length);
    }

    public static void composingFunctions() {
        // "key:value"
        // first "key=value"
        // second "{key=value}"

        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        // Declarative Programming
        var result = replaceColon
                        .andThen(addBraces)
                        .apply("key:value");
        System.out.println(result);

        // compose functions in the reverse order
        result = addBraces.compose(replaceColon).apply("key:value");
        System.out.println(result);
    }
}
