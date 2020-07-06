package com.belsoft.polymorphism;

public class Polymorphism {
    public static void main(String[] args) {

        UIControl[] controls = {new TextBox(), new CheckBox()};
        for (var control : controls) {
            control.render();
        }
    }
}
