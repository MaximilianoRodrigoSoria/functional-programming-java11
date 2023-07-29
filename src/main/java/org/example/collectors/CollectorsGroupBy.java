package org.example.collectors;

import org.example.util.Console;
import org.example.util.Database;
import org.example.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGroupBy {
    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();
        Map<Console,List<Videogame>> result = videogameStream
                .collect(Collectors.groupingBy(Videogame::getConsole));
        result.forEach((k,v)-> System.out.println(k+" - "+v));
    }
}
