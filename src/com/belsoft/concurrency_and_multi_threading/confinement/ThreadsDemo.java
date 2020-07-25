package com.belsoft.concurrency_and_multi_threading.confinement;

import com.belsoft.concurrency_and_multi_threading.race_conditions.DownloadFileTask3;

import java.util.ArrayList;
import java.util.List;

public class ThreadsDemo {
    public static void show() {
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask3> tasks = new ArrayList<>();

        for (var i = 0; i < 10; i++ ) {
            var task = new DownloadFileTask3();
            tasks.add(task);

            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }

        var totalBytes = tasks.stream()
                .map(t -> t.getStatus().getTotalBytes())
                .reduce(0, Integer::sum);

        System.out.println("Total bytes : " + totalBytes);
    }
}
