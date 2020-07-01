package com.belsoft;

import java.util.Arrays;

public class ArraysInJava {

    public static void main(String[] args) {

        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] words = new String[5];
        System.out.println(Arrays.toString(words));

        int[] myNumbers = { 3, 1, 5, 9, 7 };
        System.out.println(Arrays.toString(myNumbers));
        System.out.println(myNumbers.length);
        Arrays.sort(myNumbers);
        System.out.println(Arrays.toString(myNumbers));
    }
}
