package com.belsoft.lambdas.supplier_interface;

import java.util.function.Supplier;

public class LambdasDemo {
    public static void show() {

        //etc... on primitive type specialized methods
        //BooleanSupplier booleanSupplier
        //DoubleSupplier doubleSupplier

        Supplier<Double> getRandom = () -> Math.random();
        //lazy evaluation, you have to ask for it
        var random = getRandom.get();
        System.out.println(random);
    }
}
