package com.belsoft.the_executive_framework.project_best_price_finder;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void show() {
        var start = LocalTime.now();
        var service = new FlightService();

        try {
            CompletableFuture
                    // varargs is syntactic sugar for Array
                    .allOf(
                            service
                                    .getQuotes()
                                    .map(future -> future.thenAccept(System.out::println))
                                    .toArray(CompletableFuture[]::new)
                    )
                    .thenRun(() -> {
                        var end = LocalTime.now();
                        var duration = Duration.between(start, end);
                        System.out.println("Retrieved all quotes in " + duration.toMillis() + "msec");
                    })
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
