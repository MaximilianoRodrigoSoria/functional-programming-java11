package org.example.temp;

import org.example.fundamentals.Product;
import org.example.lambdas.Printer;

public class AppGenericLambda {

    public static void main(String[] args) {
        Printer<String> printer = string -> System.out.println(string);
        printer.print("Hola");

        Printer<Product> printerProduct = product -> System.out.println(product.toString());

        Product p = new Product();
        p.setId(1L);
        p.setName("Televisor");
        p.setPrice(10000.0);

        printerProduct.print(p);

    }
}
