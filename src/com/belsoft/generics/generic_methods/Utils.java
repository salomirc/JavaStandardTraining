package com.belsoft.generics.generic_methods;

import com.belsoft.generics.GenericList;
import com.belsoft.generics.comparable_interface.User;
import com.belsoft.generics.generic_classes_inheritance.Instructor;

import java.util.Objects;

public class Utils {

    public static <T> String sum(T first, T second) {
        return first.toString() + second.toString();
    }

    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(String.format("Key = %1$s, Value = %2$s", key, value));
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    // class CAP#1 extends User {}
    // class Instructor extends User {}
    public static void printUsers(GenericList<? extends User> users) {
        User x = users.get(0);

        // error
        // with the "extends" can only read but can not write to this GenericList<? extends User>
        // users.add(new User(10));
    }

    // class CAP#1 extends Object {}
    // in this example Object is the parent of User
    // class Instructor extends User {}
    public static void printUsersReadWrite(GenericList<? super User> users) {

        users.add(new User(10));
        users.add(new Instructor(10));

        // error
        // with the "super" can write but can not directly read this GenericList<? super User>
        // User x = users.get(0);

        Object x = users.get(0);
        User user = (User) users.get(0);
    }
}
