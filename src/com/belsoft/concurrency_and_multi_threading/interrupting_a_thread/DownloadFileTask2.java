package com.belsoft.concurrency_and_multi_threading.interrupting_a_thread;

public class DownloadFileTask2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        // Version I
        // the thread is doing a computation task
        for (var i = 0; i < Integer.MAX_VALUE; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                return;
            }
            System.out.println("Downloading byte " + i);
        }

        // Version II
        // When the thread is sleeping
        try {
            Thread.sleep(5000);
            System.out.println("Download complete: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
