package com.belsoft.the_executive_framework.handling_exceptions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather.");
            throw new IllegalStateException();
        });

        try {
            // exceptionally() method return a new CompletableFuture
            // the new CompletableFuture return default value if an exception is thrown
            // if we call get() method on the original CompletableFuture will get an exception
            var temp = future.exceptionally(ex -> 1).get();
            System.out.println(temp);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
