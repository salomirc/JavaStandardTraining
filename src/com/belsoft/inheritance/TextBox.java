package com.belsoft.inheritance;

public class TextBox extends UIControl {

    private String text = "";

    public TextBox() {
        super(true);
//        System.out.println("TextBox");
    }

    @Override
    public String toString() {
        return text;
    }

    public void clear() {
        text = "";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
