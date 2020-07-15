package com.belsoft.streams.grouping_elements;

import com.belsoft.streams.Movie;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingElementsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        List<String> strings = List.of("A", "B", "C");


        // Map<Genre, List<Movie>>
        Map<Genre, List<Movie>> result1 = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println(result1);
        System.out.println();

        // Map<Genre, Set<Movie>>
        Map<Genre, Set<Movie>> result2 = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.toSet()));
        System.out.println(result2);
        System.out.println();

        // Map<Genre, Long>
        Map<Genre, Long> result3 = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
        System.out.println(result3);
        System.out.println();

        // Map<Genre, String>
        Map<Genre, String> result4 = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(
                                Movie::getTitle,
                                Collectors.joining(", ")
                        )));
        System.out.println(result4);
        System.out.println();
    }
}
