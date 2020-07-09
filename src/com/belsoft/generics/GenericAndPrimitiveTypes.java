package com.belsoft.generics;

public class GenericAndPrimitiveTypes {
    public static void main(String[] args) {
        // int -> Integer
        // float -> Float
        // boolean -> Boolean

        CustomGenericList<Integer> numbers = new CustomGenericList<>();
        numbers.add(1); //Boxing
        int number = numbers.get(0); //Unboxing
    }
}
