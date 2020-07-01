package com.belsoft;

import java.awt.*;

public class PrimitiveTypesVsReferenceTypes {

    public static void main(String[] args) {

        //primitive types (value types)
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(y);

        //reference types
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        point1.y = 2;
        System.out.println(point2);
    }
}
