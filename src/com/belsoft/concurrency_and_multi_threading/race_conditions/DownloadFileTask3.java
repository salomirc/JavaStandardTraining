package com.belsoft.concurrency_and_multi_threading.race_conditions;

public class DownloadFileTask3 implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask3() {
        status = new DownloadStatus();
    }

    public DownloadFileTask3(DownloadStatus status) {
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
