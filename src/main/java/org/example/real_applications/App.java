package org.example.real_applications;

import org.example.util.Database;
import org.example.util.Review;
import org.example.util.Videogame;

import java.util.Comparator;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
    var myArray = videogames
            .distinct()
            .sorted(Comparator.comparing(Videogame::getTotalSold))
            .flatMap(v-> v.getReviews().stream().map(Review::getComment))
            .filter(comment -> comment.contains("best"))
            .map("Good comment"::concat)
            .toArray();
        System.out.println(myArray);
    }


}
