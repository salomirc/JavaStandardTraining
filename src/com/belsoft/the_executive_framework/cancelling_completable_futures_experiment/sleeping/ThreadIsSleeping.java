package com.belsoft.the_executive_framework.cancelling_completable_futures_experiment.sleeping;


import com.belsoft.the_executive_framework.callables_and_futures.LongTask;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThreadIsSleeping {
    public static void show() {
        // Version II
        // When the thread is sleeping
        var future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("ShortTask simulate by sleep on thread : " + Thread.currentThread().getName());
            LongTask.simulate(3000);
            System.out.println("future2 is returning.");
            return 100;
        });

        future2.thenAccept((r) -> {
            System.out.println("future2 result is: " + r);
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // future2 will not cancel
        future2.cancel(true);

        try {
            future2.get();
        }
        catch (CancellationException e) {
            System.out.println("future1 was cancelled.");
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is finishing in 5 seconds.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Exit.");
    }
}
