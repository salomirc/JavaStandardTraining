package com.belsoft.streams.simple_reducers;

import com.belsoft.streams.Movie;

import java.util.Comparator;
import java.util.List;

public class SimpleReducersDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30),
                new Movie("d", 40)
        );

        //count()
        var count = movies.stream().count();
        System.out.println(count);

        //anyMatch
        var result = movies.stream()
                .anyMatch(movie -> movie.getLikes() > 20);
        System.out.println(result);

        //allMatch -> if all elements satisfies the condition
        result = movies.stream()
                .allMatch(movie -> movie.getLikes() > 20);
        System.out.println(result);

        //noneMatch -> if no elements satisfies the condition
        result = movies.stream()
                .noneMatch(movie -> movie.getLikes() > 20);
        System.out.println(result);

        // findFirst() return an Optional<T> to prevent null pointer exception;
        var firstElement = movies.stream()
                .findFirst()
                .get();
        System.out.println(firstElement.getTitle());

        // findAny() return an Optional<T> containing any element of the stream;
        var anyElement = movies.stream()
                .findAny()
                .get();
        System.out.println(anyElement.getTitle());

        // max() return the maximum value based on the given comparison criteria;
        var maxElement = movies.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get();
        System.out.println(maxElement.getTitle());


    }
}
