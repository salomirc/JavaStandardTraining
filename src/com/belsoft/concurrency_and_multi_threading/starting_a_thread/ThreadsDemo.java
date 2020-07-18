package com.belsoft.concurrency_and_multi_threading.starting_a_thread;

public class ThreadsDemo {
    public static void show() {
        System.out.println(Thread.currentThread().getName());

        for (var i = 0; i < 10; i++){
            Thread thread = new Thread(new DownloadFileTask1());
            thread.start();
        }
    }
}
