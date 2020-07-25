package com.belsoft.concurrency_and_multi_threading.thread_signalling;


public class ThreadsDemo {
    public static void show() {
        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask7(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " was interrupted.");
                    }
                }
            }
            System.out.println("Total bytes: " + status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }
}
