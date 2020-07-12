package com.belsoft.collections.queue_interface;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show() {

        // Queue has FIFO (First In - First Out) structure
        // Elements inserted at the tail
        // Elements removed from the head

        Queue<String> queue = new ArrayDeque<>();

        // add to the tail of the collection
        queue.add("c");
        queue.add("a");
        queue.add("b");
        // b -> a -> c
        System.out.println(queue);

        // in the case of ArrayDeque behave the same as add() method
        queue.offer("d");
        // d -> b -> a -> c
        System.out.println(queue);

        var front = queue.peek();
        System.out.println(front);

        queue.clear();
        // return null if empty queue
        front = queue.peek();
        System.out.println(front);

        queue.add("c");
        queue.add("a");
        queue.add("b");
        // b -> a -> c
        System.out.println(queue);

        // remove from the head
        // also throws an exception if queue is empty
        front = queue.remove();
        System.out.println(front);
        System.out.println(queue);

        queue.clear();
        System.out.println(queue);
        // remove from the head
        // return null if queue is empty
        front = queue.poll();
        System.out.println(front);
    }
}
