package com.belsoft.polymorphism;

public abstract class UIControl {
    private boolean isEnabled = true;

    public abstract void render();

    public final void enable() {
        isEnabled = true;
    }

    public final void disable() {
        isEnabled = false;
    }
}
