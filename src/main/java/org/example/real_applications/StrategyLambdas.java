package org.example.real_applications;

import lombok.Builder;
import lombok.Data;

import java.util.List;

class StrategyLambdas {
    public static void main(String[] args) {
        var p1 = Product.builder().id(1L).name("Bear").price(150.0).userType("BASIC").build();
        var p2 = Product.builder().id(2L).name("Bear").price(150.0).userType("PLUS").build();
        var p3 = Product.builder().id(3L).name("Bear").price(150.0).userType("PRIME").build();
        var products = List.of(p1, p2, p3);

        products.forEach(p -> {
            switch (p.getUserType()) {
                case "BASIC" -> p.setDiscountStrategy(Strategies.basicDiscount);
                case "PLUS" -> p.setDiscountStrategy(Strategies.plusDiscount);
                case "PRIME" -> p.setDiscountStrategy(Strategies.primeDiscount);
                default -> throw new IllegalArgumentException("Invalid user type: " + p.getUserType());
            }
        });

        products.forEach(p -> {
            System.out.println("Price: " + p.getPrice() + ", User type: " + p.getUserType() + ", Discount: " + p.getDiscountStrategy().get(p.getPrice()));
        });
    }
}

@FunctionalInterface
interface ApplyDiscountStrategy {
    Double get(Double price);
}

@Data
@Builder
class Product {
    private Long id;
    private String userType;
    private String name;
    private Double price;
    private ApplyDiscountStrategy discountStrategy;
}

class Strategies {
    static ApplyDiscountStrategy basicDiscount = p -> p * 0.02;
    static ApplyDiscountStrategy plusDiscount = p -> p * 0.05;
    static ApplyDiscountStrategy primeDiscount = p -> p * 0.08;
}
