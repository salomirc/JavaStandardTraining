package com.belsoft.the_executive_framework.running_code_on_completion;

public class ShortTask {
    public static void simulate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
