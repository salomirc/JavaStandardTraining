package com.belsoft;

public class Casting {

    public static void main(String[] args) {

        //implicit casting
        // byte > short > int > long > float > double

        short x = 1;
        int y = x + 2;
        System.out.println(y);

        double a = 1.1;
        double b = a + 2; // 2 converted under the hood to 2.0 first
        System.out.println(b);
    }
}
