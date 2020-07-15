package com.belsoft.streams.slicing_streams;

import com.belsoft.streams.Movie;

import java.util.List;

public class SlicingStreamsDemo {
    public static void show() {
        // limit(n)
        // skip(n)
        // takeWhile(n)
        // dropWhile(n)

        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30),
                new Movie("d", 5)
        );

        movies.stream()
                .limit(2)
                .forEach(m -> System.out.println(m.getTitle()));
        System.out.println();

        movies.stream()
                .skip(2)
                .forEach(m -> System.out.println(m.getTitle()));
        System.out.println();


        // How to achieve pagination
        // 1000 movies
        // 10 movies per page
        // 3rd page
        // skip(20) = skip( (page - 1) x pageSize)
        // limit(10) = limit(pageSize)

        movies.stream()
                .skip(2)
                .limit(1)
                .forEach(m -> System.out.println(m.getTitle()));
        System.out.println();


        movies.stream()
                .takeWhile(m -> m.getLikes() < 20) // the moment when condition get false -> stop
                .forEach(m -> System.out.println(m.getTitle())); // we have a single element : "a"
        System.out.println();

        movies.stream()
                .dropWhile(m -> m.getLikes() < 20) // the moment when condition get false -> stop
                .forEach(m -> System.out.println(m.getTitle()));
        System.out.println();
    }
}
