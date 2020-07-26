package com.belsoft.the_executive_framework.executors;

import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show() {
        var executor = Executors.newFixedThreadPool(2);
        System.out.println(executor.getClass().getName());

        try {
            for (var i = 0; i < 10; i++) {
                executor.submit(() -> {
                    System.out.println("Current thread name is : " + Thread.currentThread().getName());
                });
            }
        }
        finally {
            executor.shutdown();
        }
    }
}
