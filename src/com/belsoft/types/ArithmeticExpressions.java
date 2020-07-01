package com.belsoft.types;

public class ArithmeticExpressions {

    public static void main(String[] args) {

        int result = 10 + 3;
        System.out.println(result);

        result = 10 - 3;
        System.out.println(result);

        result = 10 * 3;
        System.out.println(result);

        result = 10 / 3; // result = 3
        System.out.println(result);

        float fDecimalResult = 10F / 3;
        System.out.println(fDecimalResult);

        double dDecimalResult = 10D / 3;
        System.out.println(dDecimalResult);

        int x = 1;
        int y = x++; //post increment
        System.out.println(x);
        System.out.println(y);

        x = 1;
        y = ++x; //pre increment
        System.out.println(x);
        System.out.println(y);


        //Compound assignment operators

        x = 1;
        x = x + 2;
        System.out.println(x);

        x = 1;
        x += 2;
        System.out.println(x);

        x = 4;
        x -= 2;
        x *= 2;
        x /= 2;
        System.out.println(x);


    }
}
