package com.belsoft.streams.getting_distinct_elements;

import com.belsoft.streams.Movie;

import java.util.List;

public class DistinctElementsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 10),
                new Movie("d", 20),
                new Movie("e", 30)
        );

        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);
    }
}
