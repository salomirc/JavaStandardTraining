package com.belsoft.the_executive_framework.implementing_an_asynchronous_api;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public void send() {
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }

    public CompletableFuture<Void> sendAsync() {
        return CompletableFuture.runAsync(this::send);
    }
}
