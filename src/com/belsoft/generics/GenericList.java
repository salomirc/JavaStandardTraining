package com.belsoft.generics;

import com.belsoft.generics.comparable_interface.User;

//public class GenericList<T extends Number> {
public class GenericList<T extends Comparable<User> & Cloneable> {
    private final T[] items = (T[]) new Comparable[10];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
