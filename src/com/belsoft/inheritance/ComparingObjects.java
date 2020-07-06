package com.belsoft.inheritance;

public class ComparingObjects {
    public static void main(String[] args) {
        var point1 = new Point(1, 2);
        var point2 = new Point(1, 2);

        System.out.println(point1.equals(new TextBox()));
        System.out.println(point1.equals(point2));
        System.out.println();
        System.out.println(point1.hashCode());
        System.out.println(point2.hashCode());
    }
}
