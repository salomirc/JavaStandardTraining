package com.belsoft.the_executive_framework.handling_timeouts;

import com.belsoft.the_executive_framework.callables_and_futures.LongTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void show() {

        var task = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            System.out.println("Task completed with value 1");
            return 1;
        });

        try {
            var result = task
                    .completeOnTimeout(0, 1, TimeUnit.SECONDS)
                    .get();
            System.out.println("Result is : " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
