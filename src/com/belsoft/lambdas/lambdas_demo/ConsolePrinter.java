package com.belsoft.lambdas.lambdas_demo;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
