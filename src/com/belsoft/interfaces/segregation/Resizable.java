package com.belsoft.interfaces.segregation;

public interface Resizable {

    //interface segregation should be done by capabilities.
    void resize(int size);
    void resize(int x, int y);
    void resizeTo(UIWidget widget);
}
