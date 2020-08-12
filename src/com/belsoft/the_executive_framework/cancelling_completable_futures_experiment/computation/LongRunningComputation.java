package com.belsoft.the_executive_framework.cancelling_completable_futures_experiment.computation;


import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class LongRunningComputation {
    public static void show() {

        // Version I
        // When the completable future is doing a long running computation
        var future1CancellationToken = new AtomicBoolean(false);
        var future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Making a long running computation on thread : " + Thread.currentThread().getName());
            int i;
            for (i = 0; i < Integer.MAX_VALUE; i++) {
                if (future1CancellationToken.get()) return 0;
                System.out.println("Downloading byte " + i);
            }
            System.out.println("future1 is returning.");
            return i;
        });

        future1.thenAccept((r) -> {
            System.out.println("future1 result is: " + r);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        future1.cancel(true);

        try {
            future1.get();
        }
        catch (CancellationException e) {
            System.out.println("future1 was cancelled.");
            future1CancellationToken.set(true);
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
