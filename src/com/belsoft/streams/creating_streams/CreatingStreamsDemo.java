package com.belsoft.streams.creating_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void show() {

        // Collection interface has the stream() method
        Collection<Integer> collection = new ArrayList<>();
        Collections.addAll(collection, 1, 2, 3);
        var stream1 = collection.stream();

        // Arrays don't have the stream() method -> use Arrays.stream() method
        int[] numbers = { 1, 2, 3 };
        var stream2 = Arrays.stream(numbers);

        stream2.forEach(n -> System.out.println(n));
        System.out.println();


        //Create a stream from an arbitrary number of objects
        var stream3 = Stream.of(1, 2, 3, 4);


        // Generate infinite (can set a limit) streams

        // Method A
        // lazy evaluation -> need to be called
        // 1.create a stream
        var stream4 = Stream.generate(() -> Math.random());
        stream4
                .limit(10) // 2. apply a transformation on the stream
                .forEach(n -> System.out.println(n)); // 3. call an operation that terminate the stream

        System.out.println();

        // Method B
        Stream.iterate(1, n -> n + 10)
                .limit(10)
                .forEach(n -> System.out.println(n));
    }
}
