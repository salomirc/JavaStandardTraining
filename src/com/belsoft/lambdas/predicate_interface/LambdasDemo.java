package com.belsoft.lambdas.predicate_interface;

import java.util.function.Predicate;

public class LambdasDemo {
    public static void show() {
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        var result = isLongerThan5.test("sky");
        System.out.println(result);
    }

    public static void combiningPredicates() {
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        //and &&, or ||, not !
        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);
        var result = hasLeftAndRightBraces.test("{AAA}");
        System.out.println(result);

        //using the negate() method
        Predicate<String> hasNotLeftAndRightBraces = hasLeftAndRightBraces.negate();
        result = hasNotLeftAndRightBraces.test("{AAA}");
        System.out.println(result);
    }
}
