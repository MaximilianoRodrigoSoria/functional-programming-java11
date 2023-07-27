package org.example.util_function;

import lombok.ToString;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

public class ExampleFunction2 {

    static Function<Person, ByteArrayOutputStream> serializer = p -> {
        ByteArrayOutputStream memoryBytes = new ByteArrayOutputStream();
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(memoryBytes)){
               objectOutputStream.writeObject(p);
               objectOutputStream.flush();

        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return memoryBytes;
    };

    static Function<ByteArrayInputStream,Person> deserializer = bais -> {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(bais)){
            return (Person) objectInputStream.readObject();
        }
        catch(IOException |ClassNotFoundException e ){
            throw new RuntimeException(e.getMessage());

        }
    };


    public static void main(String[] args) {
        ByteArrayOutputStream objectSerialized = serializer.apply(new Person("Maximiliano",35));

        System.out.println(Arrays.toString(objectSerialized.toByteArray()));

        Person objectDeserialized = deserializer.apply(new ByteArrayInputStream(objectSerialized.toByteArray()));

        System.out.println(objectDeserialized);
    }
}

@ToString
class Person implements Serializable{
    private  String name;
    private Integer age;

    public Person(String name, Integer age){
        this.age = age;
        this.name = name;
    }
}
