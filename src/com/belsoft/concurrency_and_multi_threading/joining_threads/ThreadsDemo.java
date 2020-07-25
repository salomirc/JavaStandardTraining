package com.belsoft.concurrency_and_multi_threading.joining_threads;

import com.belsoft.concurrency_and_multi_threading.starting_a_thread.DownloadFileTask1;

public class ThreadsDemo {
    public static void show() {
        var thread = new Thread(new DownloadFileTask1());
        thread.start();

        try {
            // blocking operation
            // MainThread wait for the completion of this thread
            thread.join();
            System.out.println("File is ready to be scanned.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
