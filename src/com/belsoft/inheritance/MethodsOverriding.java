package com.belsoft.inheritance;

public class MethodsOverriding {

    public static void main(String[] args) {

        var control = new TextBox();
        control.setText("Hello World!");

        //toString() method is overridden in TextBox class
        System.out.println(control.toString());
        // toString called automatically on every println() method argument
        System.out.println(control);
    }
}
