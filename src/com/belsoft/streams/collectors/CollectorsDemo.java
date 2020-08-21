package com.belsoft.streams.collectors;

import com.belsoft.streams.Movie;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

        // toList()
        List<Movie> list1 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toList());
        list1.forEach(movie -> System.out.println(movie.getTitle()));
        System.out.println();

        // toSet()
        Set<Movie> movieSet = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toSet());
        movieSet.forEach(movie -> System.out.println(movie.getTitle()));
        System.out.println();

        // toMap()
        // {key=title, value=likes}
        var map1 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));
        System.out.println(map1);
        System.out.println();

        // toMap()
        // {key=title, value=Movie}
        var map2 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
//                .collect(Collectors.toMap(Movie::getTitle, movie -> movie));
                .collect(Collectors.toMap(Movie::getTitle, Function.identity()));
        System.out.println(map2);
        System.out.println();

        // summingInt(),
        var sum1 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));
        System.out.println(sum1);
        System.out.println();

        // summingDouble(),
        var sum2 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summingDouble(Movie::getLikes));
        System.out.println(sum2);
        System.out.println();

        // summarizingInt(),
        var summarizing = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));
        System.out.println(summarizing);
        System.out.println();

        // joining()
        String join = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println(join);
        System.out.println();
    }
}
