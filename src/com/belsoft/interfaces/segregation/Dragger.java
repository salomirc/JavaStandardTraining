package com.belsoft.interfaces.segregation;

public class Dragger {
    public void drag(UIWidget widget) {
        widget.drag();
        System.out.println("Dragging done!");
    }
}
