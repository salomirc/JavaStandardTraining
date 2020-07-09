package com.belsoft.generics;

public class User implements Comparable<User>, Cloneable {
    private int age;

    private String name;
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
