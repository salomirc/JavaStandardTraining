package com.belsoft.interfaces.segregation;

// unlike classes, interfaces can have multiple parents
public interface UIWidget extends Draggable, Resizable {
    void render();
}

