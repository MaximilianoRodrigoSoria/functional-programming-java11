package org.example.real_applications;

import org.example.util.BasicVideogame;
import org.example.util.Database;
import org.example.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamIntermediateOperator {

    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();
        //distinctOperator(videogameStream);
        //limitOperator(videogameStream);
        //skipOperator(videogameStream);
        //filterOperator(videogameStream);
        //mapOperator(videogameStream);
        //mapOperator2(videogameStream);
        //flatOperator(videogameStream);
        //mapVsFlatMap(videogameStream);
        //peekOperator(videogameStream);
        //sortOperator(videogameStream);
        //takeWhileOperator(videogameStream);
        dropWhileOperator(videogameStream);
    }

    static  void distinctOperator(Stream<Videogame> stream){
        System.out.println(stream.distinct().count());
   }

    static  void limitOperator(Stream<Videogame> stream){
        List<Videogame> r = stream.limit(5).toList();

        r.forEach(System.out::println);
    }


    static  void skipOperator(Stream<Videogame> stream){
        List<Videogame> r = stream.skip(15).toList();
        r.forEach(System.out::println);
    }

    static  void filterOperator(Stream<Videogame> stream){
        List<Videogame> r = stream
                .filter(v->v.getPrice()>12.0)
                .filter(v->!v.getIsDiscount())
                .filter(v-> v.getOfficialWebsite().contains("forza"))
                .toList();
        r.forEach(System.out::println);
    }


    static  void mapOperator(Stream<Videogame> stream){
        List<String> titles = stream.map(Videogame::getName).toList();
        titles.forEach(System.out::println);
    }
    static  void mapOperator2(Stream<Videogame> stream){

        List<BasicVideogame> basicVideogames = stream
                .map(v -> {
                    return  BasicVideogame.builder()
                            .name(v.getName())
                            .price(v.getPrice())
                            .console(v.getConsole()).build();
                })
                .toList();

        basicVideogames.forEach(System.out::println);
    }

    static  void flatOperator(Stream<Videogame> stream) {
        var r = stream.flatMap(v->v.getReviews().stream()).toList();
        System.out.println(r);
    }

    static void mapVsFlatMap(Stream<Videogame> stream){
        //var totalRevies = stream.map(v->v.getReviews().size()).toList();
        var totalRevies = stream.flatMap(v->v.getReviews().stream()).count();
        System.out.println(totalRevies);
    }

    static void peekOperator(Stream<Videogame> stream){
       stream.peek(v-> v.setName(""))
             .forEach(System.out::println);
    }

    static void sortOperator(Stream<Videogame> stream){
        List<Videogame> r=stream.sorted(Comparator.comparingInt(v->v.getReviews().size())).toList();
        System.out.println(r);
    }

    static void dropWhileOperator(Stream<Videogame> stream){
        List<Videogame> r=stream
                .sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(v-> !v.getName().startsWith("M"))
                .toList();
        System.out.println(r);
    }

    static void takeWhileOperator(Stream<Videogame> stream){
        List<Videogame> listSorted=stream.sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v-> !v.getName().startsWith("M"))
                .toList();
        System.out.println(listSorted);
    }
}
