package com.belsoft.concurrency_and_multi_threading.race_conditions;

import com.belsoft.concurrency_and_multi_threading.interrupting_a_thread.DownloadFileTask2;

import java.util.ArrayList;
import java.util.List;

public class ThreadsDemo {
    public static void show() {
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++ ) {
            var thread = new Thread(new DownloadFileTask3(status));
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

        System.out.println("Total bytes : " + status.getTotalBytes());
    }
}
