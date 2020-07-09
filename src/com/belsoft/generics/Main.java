package com.belsoft.generics;

import com.belsoft.generics.comparable_interface.User;

public class Main {
    public static void main(String[] args) {
        var list = new GenericList<com.belsoft.generics.comparable_interface.User>();
        list.add(new User(23));
        var item = list.get(0);
    }
}
