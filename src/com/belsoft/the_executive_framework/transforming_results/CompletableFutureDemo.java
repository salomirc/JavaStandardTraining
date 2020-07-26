package com.belsoft.the_executive_framework.transforming_results;

import com.belsoft.the_executive_framework.running_code_on_completion.ShortTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static int toFahrenheit(int celsius) {
        return (int)(celsius * 1.8) + 32;
    }

    public static void show() {
        System.out.println("Before starting the async Task :");
        var future = CompletableFuture.supplyAsync(() -> {
            ShortTask.simulate();
            return 20;
        });

        try {
            future
                    .thenApply(CompletableFutureDemo::toFahrenheit)
                    .thenAccept((f) -> System.out.println("The result is : " + f))
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
