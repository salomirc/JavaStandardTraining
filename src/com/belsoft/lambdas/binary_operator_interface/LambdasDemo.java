package com.belsoft.lambdas.binary_operator_interface;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class LambdasDemo {
    public static void show() {

        // a, b -> a + b -> square
        BinaryOperator<Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> square = a -> a * a;

        var result = add.andThen(square).apply(2, 3);
        System.out.println(result);
    }
}
