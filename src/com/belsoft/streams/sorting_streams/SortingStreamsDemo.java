package com.belsoft.streams.sorting_streams;

import com.belsoft.streams.Movie;

import java.util.Comparator;
import java.util.List;

public class SortingStreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("b", 10),
                new Movie("a", 20),
                new Movie("c", 30)
        );

        // sorting by title
        movies.stream()
                   // lambda expression for Comparator interface or an object that implements that interface
//                .sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))

                   // (better) use the static method comparing() from Comparator interface
//                .sorted(Comparator.comparing(movie -> movie.getTitle()))

                // replace the lambda expression with method reference
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(movie -> System.out.println(movie.getTitle()));
        System.out.println();

        // reversed
        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(movie -> System.out.println(movie.getTitle()));
        System.out.println();
    }
}
