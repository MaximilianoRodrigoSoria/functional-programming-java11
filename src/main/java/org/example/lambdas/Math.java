package org.example.lambdas;

@FunctionalInterface
public interface Math {
    Double execute(Double a, double b);

    default Double sum(Double a, double b){return  a + b;};
}
