package org.example.collectors;

import org.example.util.Database;
import org.example.util.Videogame;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectosToCollection {


    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();

        //streamToCollection(videogameStream,"LIST").forEach(System.out::println);
        streamToMap(videogameStream).forEach((k,v)-> System.out.println(k.concat(" - ".concat(String.valueOf(v)))));
    }


    static Collection<Videogame> streamToCollection(Stream<Videogame> stream, String type){
        return (type.equals("LIST")) ? stream.collect(Collectors.toList()):stream.collect(Collectors.toSet());
    }


    static Map<String,Double> streamToMap(Stream<Videogame> stream){

        return stream.distinct().collect(Collectors.toMap(Videogame::getName,Videogame::getPrice));
    }
}

