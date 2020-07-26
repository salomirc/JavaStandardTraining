package com.belsoft.the_executive_framework.composing_completable_futures;

import com.belsoft.the_executive_framework.running_code_on_completion.ShortTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static CompletableFuture<String> getUserAsync() {
        return CompletableFuture.supplyAsync(() -> {
            ShortTask.simulate();
            System.out.println("email");
            return "email";
        });
    }

    public static CompletableFuture<String> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> {
            ShortTask.simulate();
            System.out.println("playlist");
            return "playlist";
        });
    }

    public static void show() {

        try {
            System.out.println("Starting the network requests ...");
            getUserAsync()
               .thenCompose(CompletableFutureDemo::getPlaylistAsync)
               .thenAccept(System.out::println)
               .get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
