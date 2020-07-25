package com.belsoft.concurrency_and_multi_threading.the_volatile_keyword;


public class ThreadsDemo {
    public static void show() {
        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask6(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {}
            System.out.println("Total bytes: " + status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }
}
