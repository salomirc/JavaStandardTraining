package com.belsoft.concurrency_and_multi_threading.concurrent_collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadsDemo {
    public static void show() {
        // achieve threads safety by using partitioning techniques under the hood -> good performance
        Map<Integer, String> map = new ConcurrentHashMap<>();

        var thread1 = new Thread(() -> {
            map.putAll(Map.of(1, "b", 2, "c", 3, "d"));
        });

        var thread2 = new Thread(() -> {
            map.putAll(Map.of(4, "e", 5, "f", 6, "g"));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }

        System.out.println(map);
    }
}
