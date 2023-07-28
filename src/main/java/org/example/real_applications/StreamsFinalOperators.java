package org.example.real_applications;

import org.example.util.Database;
import org.example.util.Videogame;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamsFinalOperators {

    public static void main(String[] args) {

        Stream<Videogame> videogames = Database.videogames.stream();
        //countOperator(videogames);
        //forEachOperator(videogames);
        //anyMatchOperator(videogames);
        //allMatchOperator(videogames);
        //notMatchOperator(videogames);
        findFirstMatchOperator(videogames);
    }

    static void countOperator(Stream<Videogame> stream){
        System.out.println(stream.count());
    }

    static void forEachOperator(Stream<Videogame> stream){
        stream.forEach(System.out::println);
    }

    static void anyMatchOperator(Stream<Videogame> stream){
        boolean r = stream.anyMatch(v -> v.getTotalSold()>1000);
        System.out.println(r);
    }

    static void allMatchOperator(Stream<Videogame> stream){
        boolean r = stream.allMatch(v -> v.getTotalSold()>1000);
        System.out.println(r);
    }

    static void notMatchOperator(Stream<Videogame> stream){
        boolean r = stream.allMatch(v -> v.getReviews().isEmpty());
        System.out.println(r);
    }

    static void findFirstMatchOperator(Stream<Videogame> stream){
        var r = stream.findFirst().get();
        System.out.println(r);
    }
}
