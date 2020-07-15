package com.belsoft.streams.reducing_a_stream;

import com.belsoft.streams.Movie;

import java.util.List;
import java.util.Optional;

public class ReducingStreamDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

        // [10, 20, 30]
        // [30, 30]
        // [60]

        Optional<Integer> sum = movies.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);
        // getValueOrDefault -> if we have am empty stream will use supplied value orElse(0)
        // and avoid throwing an exception
        var result1 = sum.orElse(0);
        System.out.println(result1);


        var result2 = movies.stream()
                .map(Movie::getLikes)
                // 0 is default value
                .reduce(0, Integer::sum);
        System.out.println(result2);
    }
}
