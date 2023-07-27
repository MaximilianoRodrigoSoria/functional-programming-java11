package org.example.temp;

import lombok.ToString;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class ContructorMethodReference {
    public static void main(String[] args) {

        //Supplier<MyObject> myObject = () -> new MyObject();
        Supplier<MyObject> myObject = MyObject::new;
        System.out.println(myObject.get());
    }
}

@ToString
class MyObject{
    private String string;
    private Integer num;


    MyObject(){
        this.string = UUID.randomUUID().toString();
        this.num = new Random().nextInt(1000);
    }

}
