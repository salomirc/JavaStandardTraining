package com.belsoft.concurrency_and_multi_threading.thread_signalling;


public class DownloadFileTask7 implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask7(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        // the thread is doing a computation task
        for (var i = 0; i < 1_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                return;
            }
            status.incrementTotalBytes();
        }

        status.done();

        synchronized (status) {
            status.notify();

            // use "notifyAll()" if you have multiple threads waiting for a notification from this object
            // you can use this method also it with only one thread waiting
            //status.notifyAll();
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
