package com.belsoft.concurrency_and_multi_threading.the_volatile_keyword;


public class DownloadFileTask6 implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask6(DownloadStatus status) {
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

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
