package com.belsoft.generics.generic_methods;

import com.belsoft.generics.comparable_interface.User;

public class Main {
    public static void main(String[] args) {
        var max = Utils.max(1, 2);
        System.out.println(String.format("Max = %1$s", max));

        var user = Utils.max(new User(10), new User(20));
        System.out.println("Max user has : " + user);

        Utils.print("Mosh", 100);
    }
}
