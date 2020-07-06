package com.belsoft.inheritance;

public class AccessModifiers {

    // default access modifier is "package-private"
    // which means access is restricted to the current package
    String firstName;

    // public - access is not restricted
    public long serialNUmber;

    // private - access is restricted to the containing type
    private String lastName;

    // protected - access is restricted to the current package
    // or types derived from the containing class
    protected int age;

}
