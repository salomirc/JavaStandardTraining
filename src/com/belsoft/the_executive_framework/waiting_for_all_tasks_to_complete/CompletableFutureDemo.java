package com.belsoft.the_executive_framework.waiting_for_all_tasks_to_complete;

import com.belsoft.the_executive_framework.callables_and_futures.LongTask;
import com.belsoft.the_executive_framework.running_code_on_completion.ShortTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void show() {
        var first = CompletableFuture.supplyAsync(() -> {
            ShortTask.simulate();
            ShortTask.simulate();
            System.out.println(1);
            return 1;
        });

        var second = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            System.out.println(2);
            return 2;
        });

        var third = CompletableFuture.supplyAsync(() -> {
            ShortTask.simulate();
            System.out.println(3);
            return 3;
        });

        try {
            // wait for all tasks to complete in an async way (non blocking)
            CompletableFuture.allOf(first, second, third)
                    .thenRun(() -> {
                        try {
                            var firstResult = first.get();
                            var secondResult = second.get();
                            var thirdResult = third.get();

                            System.out.println(firstResult + " " + secondResult + " " + thirdResult);
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                        System.out.println("All tasks completed successfully");
                    })
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
