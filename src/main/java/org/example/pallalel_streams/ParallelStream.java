package org.example.pallalel_streams;

import java.util.List;

public class ParallelStream {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,5,6,7,8);
        numbers.parallelStream().forEach( n-> System.out.println(n + " " + Thread.currentThread().getName()));

    }
}
