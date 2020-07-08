package com.belsoft.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void show(){
//        sayHello(null);

        try {
            var reader = new FileReader("file.txt");
            var value = reader.read();
            new SimpleDateFormat().parse("");
        }
        catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
            System.out.println("File does not exist.");
        }
        catch (IOException e) {
            System.out.println("Could not read data.");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void handleMultipleEx() {
        FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
            var value = reader.read();
            new SimpleDateFormat().parse("");
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
            System.out.println("Could not read data.");
        }
    }

    public static void throwingExceptions() {
        var account = new Account();
        try {
            account.deposit(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //re-throwing an exception
    public static void rethrowingExceptions() throws IOException {
        var account = new Account();
        try {
            account.deposit(-1);
        } catch (IOException e) {
            System.out.println("Logging.");
            throw e;
        }
    }

    public static void throwingCustomException() {
        var account = new Account();
        try {
            account.withdraw(10);
        } catch (AccountException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
    }

    public static void sayHello(String name){
        System.out.println(name.toUpperCase());
    }
}
