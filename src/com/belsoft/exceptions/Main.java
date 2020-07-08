package com.belsoft.exceptions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        ExceptionsDemo.show();
//        ExceptionsDemo.handleMultipleEx();
//        ExceptionsDemo.throwingExceptions();
        try {
            ExceptionsDemo.rethrowingExceptions();
//        } catch (Exception e) {
        } catch (Throwable e) {
            System.out.println("An unexpected error occurred.");
        }

        ExceptionsDemo.throwingCustomException();
    }
}
