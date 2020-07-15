package com.belsoft.streams.primitive_type_streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveTypeStreamsDemo {
    public static void show() {

        // When working with primitive values
        // It is more efficient to use one of the specialized types

        // upper bound is inclusive
        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);
        System.out.println();

        // upper bound is exclusive
        IntStream.range(1, 5)
                .forEach(System.out::println);
        System.out.println();

        // LongStream
        LongStream.rangeClosed(1, 5)
                .forEach(System.out::println);
        System.out.println();

        // DoubleStream
        DoubleStream.of(1, 5, 7, 9, 8)
                .forEach(System.out::println);
        System.out.println();
    }
}
