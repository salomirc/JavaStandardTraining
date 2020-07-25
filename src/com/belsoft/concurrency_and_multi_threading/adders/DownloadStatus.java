package com.belsoft.concurrency_and_multi_threading.adders;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {

    // faster than atomic types
    private final LongAdder totalBytes = new LongAdder();

    public int getTotalBytes() {
        return totalBytes.intValue();
    }

    public void incrementTotalBytes() {
        totalBytes.increment();
    }
}
