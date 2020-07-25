package com.belsoft.concurrency_and_multi_threading.atomic_objects;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus {
    private final AtomicInteger totalBytes = new AtomicInteger();

    public int getTotalBytes() {
        return totalBytes.get();
    }

    public void incrementTotalBytes() {
        totalBytes.incrementAndGet(); // ++i
        //totalBytes.getAndIncrement(); // i++
    }
}
