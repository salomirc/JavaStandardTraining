package com.belsoft.concurrency_and_multi_threading.the_volatile_keyword;

public class DownloadStatus {
    private volatile boolean isDone;
    private int totalBytes;
    private int totalFiles;
    private final Object totalBytesLock = new Object();
    private final Object totalFilesLock = new Object();
    // synchronization and locks are bad because you loose concurrency
    // generally speaking you should avoid this

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }
    public void incrementTotalFiles() {
        synchronized (totalFilesLock) {
            totalFiles++;
        }
    }

    // equivalent with the above method but using "this" as synchronization object
    // use with caution, can cause unnecessary waits

    public synchronized void incrementTotalFilesSync() {
        totalFiles++;
    }
    public int getTotalBytes() {
        return totalBytes;
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}
