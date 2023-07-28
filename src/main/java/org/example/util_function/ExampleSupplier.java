package org.example.util_function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.function.Supplier;

public class ExampleSupplier {

    static Supplier<Integer> randomInt= ()-> new Random().nextInt(100);

    static Supplier<MyProduct> productSupplier= ()-> new MyProduct(100,"Cellphone");
    public static void main(String[] args) {

        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(productSupplier.get());
    }
}



@Data
@NoArgsConstructor
@AllArgsConstructor
class MyProduct{
    private Integer price;
    private String name;


}
