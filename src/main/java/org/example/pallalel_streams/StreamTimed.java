package org.example.pallalel_streams;

import java.util.stream.IntStream;

public class StreamTimed {

    public static void main(String[] args) {
        long strartTime = System.currentTimeMillis();
        IntStream.range(1,2000000000).reduce(0,Integer::sum);
        long endTime = System.currentTimeMillis();

        System.out.println("Total time: " +(endTime - strartTime));

    }
}
