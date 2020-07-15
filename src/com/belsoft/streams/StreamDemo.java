package com.belsoft.streams;

import java.util.List;

public class StreamDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Imperative programming
        // is about "how" to be done
        int count = 0;
        for (var movie : movies)
            if (movie.getLikes() > 10)
                count++;
        System.out.println(count);

        // Declarative (functional) programming
        // is about "what" to be done
        count = (int)movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();
        System.out.println(count);
    }
}
