package org.example.collectors;

import org.example.util.Database;
import org.example.util.Videogame;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsPartitions {
    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();
        Map<Boolean, List<Videogame>> result = videogameStream
                .collect(Collectors.partitioningBy(v-> v.getPrice()>15.0));
        result.forEach((k,v)-> System.out.println(k+" - "+v));
    }



}
