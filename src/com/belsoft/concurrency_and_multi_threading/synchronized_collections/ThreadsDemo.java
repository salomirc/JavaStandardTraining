package com.belsoft.concurrency_and_multi_threading.synchronized_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ThreadsDemo {
    public static void show() {
        // achieve threads safety by using locks under the hood -> limit the performance
        Collection<Integer> collection = Collections.synchronizedList(new ArrayList<>());

        var thread1 = new Thread(() -> {
            collection.addAll(List.of(1, 2, 3));
        });

        var thread2 = new Thread(() -> {
            collection.addAll(List.of(4, 5, 6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }

        System.out.println(collection);
    }
}
