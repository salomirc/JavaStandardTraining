package com.belsoft.concurrency_and_multi_threading.processes_and_threads;

public class Main {
    public static void main(String[] args) {
        // Returns the number of the active threads in the current process
        System.out.println(Thread.activeCount());

        // Returns the number of processors available to the Java virtual machine
        // (the total number of threads i.e. 4 core x 2 threads = 8 threads)
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
