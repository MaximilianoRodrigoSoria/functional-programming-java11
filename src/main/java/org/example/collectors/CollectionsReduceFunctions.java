package org.example.collectors;

import org.example.util.Database;
import org.example.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsReduceFunctions {

    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();
        //avg(videogameStream);
        //sum(videogameStream);
        join(videogameStream);
    }

    static void avg(Stream<Videogame>stream){
        Double avg = stream.collect(Collectors.averagingDouble(Videogame::getPrice));
        System.out.println(avg);
    }

    static void sum(Stream<Videogame>stream){
        IntSummaryStatistics summaryStatistics = stream.collect(Collectors.summarizingInt(v -> v.getReviews().size()));
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getMax());
    }

    static void join(Stream<Videogame>stream){
        String string = stream.map(Videogame::toString)
                .collect(Collectors.joining("\n"));

        System.out.println(string);
    }
}
