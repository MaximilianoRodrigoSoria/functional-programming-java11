package org.example.util_function;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ExampleUnaryOperator {

    static Function<String,String> toUpper = String::toUpperCase;
    static UnaryOperator<String> toUpperUnary = String::toUpperCase;

    public static void main(String[] args) {

        String arg1 = "Hola Mundo";

        String arg2 = "Hello Word";

        System.out.println(toUpper.apply(arg1));
        System.out.println(toUpperUnary.apply(arg2));


    }
}
