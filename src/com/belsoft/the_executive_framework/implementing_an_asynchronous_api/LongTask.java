package com.belsoft.the_executive_framework.implementing_an_asynchronous_api;

public class LongTask {
    public static void simulate() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
