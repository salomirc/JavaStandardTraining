package com.belsoft.the_executive_framework.creating_a_completable_future;

import com.belsoft.the_executive_framework.callables_and_futures.LongTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo {
    public static void  show() {
        Runnable task1 = () -> {
            LongTask.simulate();
            System.out.println("a");
        };

        Supplier<Integer> task2 = () -> {
            LongTask.simulate();
            return 1;
        };

        // CompletableFuture<Void>
        var future1 = CompletableFuture.runAsync(task1);

        // CompletableFuture<Integer>
        var future2 = CompletableFuture.supplyAsync(task2);

        try {

            // blocking operation
//            future1.get();

            // blocking operation
            var result = future2.get();
            System.out.println("The result is : " + result);
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
