package com.belsoft.inheritance;

public class UpcastingAndDowncasting {

    public static void main(String[] args) {
        var control = new UIControl(true);
        var textBox = new TextBox();
        show(control);
        show(textBox);
    }

    public static void show(UIControl control) {
        if (control instanceof TextBox) {
            var textBox = (TextBox)control;
            textBox.setText("Hello world!");
        }
        System.out.println(control);
    }
}
