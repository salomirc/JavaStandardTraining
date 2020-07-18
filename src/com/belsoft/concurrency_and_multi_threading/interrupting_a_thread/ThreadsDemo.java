package com.belsoft.concurrency_and_multi_threading.interrupting_a_thread;

public class ThreadsDemo {
    public static void show() {
        var thread = new Thread(new DownloadFileTask2());
        thread.start();

        // pause the current thread (MainThread)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }

        // send the interrupt request
        thread.interrupt();
    }
}
