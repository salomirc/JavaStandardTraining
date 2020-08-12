package com.belsoft.lambdas.lambdas_demo;

public class LambdasDemo {
    private final String prefix = "__";
    public static String sufixStatic = "____";

    public LambdasDemo(String message) {
        System.out.println("Class constructor reference.");
    }

    public LambdasDemo() {
    }

    public static void show() {

        // class instance
        greet(new ConsolePrinter());

        // anonymous inner class
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        // lambda expression
        greet(message -> System.out.println(message));

        // method reference
        // can reference in this manner instance and static methods of a class and constructors
        greet(System.out::println);

        // store lambda into a variable
        Printer printer = message -> System.out.println(message);

        String prefix = "_";
        //variable capture
        // can access local variables in the enclosing method show() (i.e. prefix)
        greet(message -> System.out.println(prefix + message));
    }

    public void show2() {

        //variable capture
        // can access containing class instance and static members
        greet(message -> System.out.println(prefix + message + Name() + sufixStatic));
    }

    public void show3() {

        //variable capture
        // "this" references the containing class current instance
        greet(message -> System.out.println(this.prefix + message + this.Name()));
    }


    private String Name() {
        return " from Java";
    }

    public static void show4() {
        greet(LambdasDemo::print);
    }

    public static void print(String message) {
        System.out.println("Static method reference.");
    }

    public void show5() {
        var demo = new LambdasDemo();
        greet(demo::instancePrint);
    }

    public void instancePrint(String message) {
        System.out.println("Instance method reference.");
    }

    public void show6() {
        // Constructor reference
        greet(LambdasDemo::new);
    }

    public static void greet(Printer printer) {
        printer.print("Hello world.");
    }
}
