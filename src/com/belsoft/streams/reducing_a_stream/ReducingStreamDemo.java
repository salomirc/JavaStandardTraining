package com.belsoft.streams.reducing_a_stream;

import com.belsoft.streams.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReducingStreamDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

        List<Movie> emptyMovieList = new ArrayList<>();

        // [10, 20, 30]
        // [30, 30]
        // [60]

        Optional<Integer> sum = movies.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);
        // C# getValueOrDefault() equivalent -> if we have am empty stream will use supplied value orElse(0)
        // and avoid throwing an exception
        var result1 = sum.orElse(0);
        System.out.println(result1);


        // empty list example
        Optional<Integer> sum1 = emptyMovieList.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);
        // C# getValueOrDefault() equivalent -> if we have am empty stream will use supplied value orElse(0)
        // and avoid throwing an exception
        var result2 = sum1.orElse(0);
        System.out.println(result2); // result2 is 0


        var result3 = movies.stream()
                .map(Movie::getLikes)
                // 0 is the initial value -> will always return something
                .reduce(0, Integer::sum);
        System.out.println(result3);


        // empty list example
        var result4 = emptyMovieList.stream()
                .map(Movie::getLikes)
                // 0 is the initial value -> default value in the getValueOrDefault() paradigm
                .reduce(0, Integer::sum);
        System.out.println(result4); // result4 is 0
    }
}
