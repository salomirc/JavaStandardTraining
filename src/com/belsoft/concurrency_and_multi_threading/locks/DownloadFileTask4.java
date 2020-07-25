package com.belsoft.concurrency_and_multi_threading.locks;


public class DownloadFileTask4 implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask4(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        // the thread is doing a computation task
        for (var i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                return;
            }
            status.incrementTotalBytes();
        }
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
