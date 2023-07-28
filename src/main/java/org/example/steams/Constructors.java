package org.example.steams;

import org.example.util.Database;
import org.example.util.Videogame;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Constructors {

    public static void main(String[] args) {

        Stream<Videogame> myStream = Database.videogames.stream();


        myStream.forEach(System.out::println);

        System.out.println("-------------------------");

        Integer[]myArray = {1,2,3,4,5};

        Stream<Integer> intStream = Arrays.stream(myArray);

        intStream.forEach(System.out::println);

        Stream.of("Hola","Mundo").forEach(System.out::println);

        DoubleStream.of(1.0,2.3,5.1,10.11).forEach(System.out::println);

    }
}
