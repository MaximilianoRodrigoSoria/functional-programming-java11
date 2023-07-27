package org.example.util_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ExamplePredicate {

    static Predicate<Integer>  isGreaterThan100 = n ->  n > 100;
    static Predicate<Integer>  isLessThan10 = n ->  n < 10;

    static Predicate<Integer>  isBetween10and100 = isGreaterThan100.or(isLessThan10);
    public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,10,55,20,30,40,50,600,8,200));


    numbers.removeIf(isBetween10and100);

    System.out.println(numbers);
    }


}
