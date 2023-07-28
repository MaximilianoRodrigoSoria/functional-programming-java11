package org.example.util_function;

import java.util.function.BinaryOperator;

public class ExampleBinaryOperator {



    public static void main(String[] args) {
    //BiFunction<String,String,String> normalizerFunc = (a,b) -> a.toUpperCase().concat(" - ").concat(b.toLowerCase());
    BinaryOperator<String> normalizerFunc = (a,b) -> a.toUpperCase().concat(" - ").concat(b.toLowerCase());
    System.out.println(normalizerFunc.apply("hola", "mundo"));
    }
}
