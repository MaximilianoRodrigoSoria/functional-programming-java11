package org.example.temp;

import org.example.lambdas.Math;

public class LambdaApp {
    public static void main(String[] args) {

        Math sustract = new Math() {
            @Override
            public Double execute(Double a, double b) {
                return a - b;
            }
        };
        System.out.println(sustract.execute(12.0, 5.0));

        Math multiply = (a, b) -> a * b;
        System.out.println(multiply.execute(3.0, 5.0));


        Math divide = (a, b) -> {
            System.out.println("Se hace una division: ");
            return a * b;
        };
        System.out.println(divide.execute(3.0, 6.0));

    }

}
