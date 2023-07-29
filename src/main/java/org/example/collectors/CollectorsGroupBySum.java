package org.example.collectors;

import org.example.util.Console;
import org.example.util.Database;
import org.example.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGroupBySum {
    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();
        Map<Console, IntSummaryStatistics> result = videogameStream
                .collect(
                        Collectors.groupingBy(
                                Videogame::getConsole,
                                Collectors.summarizingInt(Videogame::getTotalSold)));
        result.forEach((k,v)-> System.out.println(k+" - "+v.getSum()));
    }
}
