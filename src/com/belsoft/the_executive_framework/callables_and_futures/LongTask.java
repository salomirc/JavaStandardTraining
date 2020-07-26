package com.belsoft.the_executive_framework.callables_and_futures;

public class LongTask {

    public static void simulate() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }

    public static void simulate(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
