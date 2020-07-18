package com.belsoft.concurrency_and_multi_threading.starting_a_thread;

public class DownloadFileTask1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());


        // pause a thread
        try {
            Thread.sleep(5000);
            System.out.println("Download complete: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
