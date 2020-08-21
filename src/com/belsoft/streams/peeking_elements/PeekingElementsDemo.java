package com.belsoft.streams.peeking_elements;

import com.belsoft.streams.Movie;

import java.util.List;

public class PeekingElementsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("d", 30)
        );

        // peek() method used to get the output of each operations (for debugging)
        movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .peek(movie -> System.out.println("filtered: " + movie.getLikes()))
                .map(Movie::getTitle)
                .peek(s -> System.out.println("mapped: " + s))
                .forEach(System.out::println);
    }
}
