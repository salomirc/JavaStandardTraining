package com.belsoft.generics.generic_classes_inheritance;

import com.belsoft.generics.GenericList;
import com.belsoft.generics.comparable_interface.User;
import com.belsoft.generics.generic_methods.Utils;

public class Main {
    public static void main(String[] args) {
        User user = new Instructor(10);
        Utils.printUser(new Instructor(10));

        var instructors = new GenericList<Instructor>();
        var users = new GenericList<User>();
        Utils.printUsers(users);
        Utils.printUsers(instructors);
    }
}
