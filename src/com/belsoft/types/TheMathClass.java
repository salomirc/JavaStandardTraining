package com.belsoft.types;

public class TheMathClass {

    public static void main(String[] args) {

        int result = Math.round(1.49F);
        System.out.println(result); //1

        result = Math.round(1.5F);
        System.out.println(result); //2

        result = Math.round(1.6F);
        System.out.println(result); //2

        result = (int)Math.ceil(1.1F);
        System.out.println(result); //2

        result = (int)Math.floor(1.9);
        System.out.println(result); //1

        result = (int)Math.max(4, 5);
        System.out.println(result); //5

        result = (int)Math.min(4, 5);
        System.out.println(result); //4

        double randomNumber = Math.random(); // double between 0.0 and 1.0
        System.out.println(randomNumber);

        randomNumber = Math.random() * 100; // double between 0.0 and 100.0
        System.out.println(randomNumber);

        int randomIntNumber = (int) (Math.random() * 100); // double between 0.0 and 100.0
        System.out.println(randomIntNumber);
    }
}
