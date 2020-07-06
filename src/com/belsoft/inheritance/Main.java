package com.belsoft.inheritance;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        var control = new TextBox();
        control.disable();
        System.out.println(control.isEnabled());

        var box1 = new TextBox();
        var box2 = new TextBox();
        System.out.println(box1.hashCode());
        System.out.println(box2.hashCode());
        System.out.println(box1.toString());
        System.out.println(box2.toString());
        System.out.println(box1.equals(box2));
        System.out.println(box1 == box2);
        System.out.println();

        String name1 = "AAA";
        String name2 = "AAA";
        System.out.println(Objects.equals(name1, name2));
        System.out.println(name1.equals(name2));
        System.out.println(name1 == name2);
        System.out.println(name1 != name2);
    }
}
