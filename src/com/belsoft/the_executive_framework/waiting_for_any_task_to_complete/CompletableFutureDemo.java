package com.belsoft.the_executive_framework.waiting_for_any_task_to_complete;

import com.belsoft.the_executive_framework.callables_and_futures.LongTask;
import com.belsoft.the_executive_framework.running_code_on_completion.ShortTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void show() {

        var first = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            System.out.println(20);
            return 20;
        });

        var second = CompletableFuture.supplyAsync(() -> {
            ShortTask.simulate();
            System.out.println(10);
            return 10;
        });

        try {
            CompletableFuture
                    .anyOf(first, second)
                    .thenAccept(temp -> System.out.println("The temperature is : " + temp))
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
