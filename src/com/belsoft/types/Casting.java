package com.belsoft.types;

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

        //explicit casting
        double c = 1.1;
        int d = (int)c + 2;
        System.out.println(d);

        //parsing
        String s = "1";
        int i = Integer.parseInt(s) + 2;
//        Short.parseShort(s);
//        Float.parseFloat(s);
//        Double.parseDouble(s);
        System.out.println(i);
    }
}
