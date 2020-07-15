package com.belsoft.streams.mapping_elements;

import com.belsoft.streams.Movie;

import java.util.List;
import java.util.stream.Stream;

public class MappingElementsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        var stream1 = movies.stream();
        stream1.forEach(movie -> System.out.println(movie.getTitle()));
        System.out.println();

        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(name -> System.out.println(name));
        System.out.println();

        movies.stream()
                .mapToInt(movie -> movie.getLikes()) // a primitive variation of the map() method
                .forEach(name -> System.out.println(name));
        System.out.println();

        // flatten the initial stream
        // Stream<List<x>> -> Stream<x>
        var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        stream
                .flatMap(list -> list.stream())
                .forEach(n -> System.out.println(n));
    }
}
