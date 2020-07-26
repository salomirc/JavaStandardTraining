package com.belsoft.the_executive_framework.combining_completable_futures;

import com.belsoft.the_executive_framework.callables_and_futures.LongTask;
import com.belsoft.the_executive_framework.running_code_on_completion.ShortTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void show() {

        // first and second task run in parallel
        var first = CompletableFuture
                .supplyAsync(() -> {
                    LongTask.simulate();
                    var priceString = "20USD";
                    System.out.println(priceString);
                    return priceString;
                })
                .thenApply(str -> {
                    var price = str.replace("USD", "");
                    return Integer.parseInt(price);
                });

        // first and second task run in parallel
        var second = CompletableFuture.supplyAsync(() -> {
            ShortTask.simulate();
            var exchangeRate = 0.9;
            System.out.println(exchangeRate);
            return exchangeRate;
        });

        try {
            first
                // waiting for both tasks to complete before calculate the result
                // async operation (non blocking)
               .thenCombine(second, (price, exchangeRate) -> price * exchangeRate)
               .thenAccept(System.out::println)
               .get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
