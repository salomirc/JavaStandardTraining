package com.belsoft.the_executive_framework.running_code_on_completion;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> {
//            ShortTask.simulate();
            return 1;
        });

        future.thenRun(() -> {
            System.out.println("thenRun()");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            System.out.println("Done. \n");
        });

        future.thenRunAsync(() -> {
            System.out.println("thenRunAsync()");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            System.out.println("Done. \n");
        });

        future.thenAccept((result) -> {
            System.out.println("thenAccept()");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            System.out.println("The result is : " + result + "\n");
        });

        future.thenAcceptAsync((result) -> {
            System.out.println("thenAcceptAsync()");
            System.out.println("Thread name : " + Thread.currentThread().getName());
            System.out.println("The result is : " + result + "\n");
        });

        System.out.println("Hello world.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
