package com.belsoft.streams.partitioning_elements;

import com.belsoft.streams.Movie;
import com.belsoft.streams.grouping_elements.Genre;

import java.util.List;
import java.util.stream.Collectors;

public class PartitioningElementsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        // Map<Boolean, List<Movie>>
        var result1 = movies.stream()
                .collect(Collectors.partitioningBy(movie -> movie.getLikes() > 20));
        System.out.println(result1);
        System.out.println();

        // Map<Boolean, List<String>>
        var result2 = movies.stream()
                .collect(Collectors.partitioningBy(
                        movie -> movie.getLikes() > 20,
                        Collectors.mapping(Movie::getTitle, Collectors.toList())));
        System.out.println(result2);
        System.out.println();

        // Map<Boolean, String>
        var result3 = movies.stream()
                .collect(Collectors.partitioningBy(
                        movie -> movie.getLikes() > 20,
                        Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));
        System.out.println(result3);
        System.out.println();
    }
}
