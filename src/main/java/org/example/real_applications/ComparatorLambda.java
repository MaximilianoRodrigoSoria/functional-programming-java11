package org.example.real_applications;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

    public static void main(String[] args) {

        List<Integer> numbs = Arrays.asList(4,6,88,1,0,22,33);

        numbs.sort((a,b)->a-b);
        System.out.println(numbs);

        List<String> strings = Arrays.asList("Maxi","Yesica","Bishop","Eluney","Shina","Lionel");
        strings.sort(String::compareTo);
        System.out.println(strings);
        strings.sort(Comparator.reverseOrder());
        System.out.println(strings);


        List<Person> persons = Arrays.asList(
                Person.builder().name("Maxi").age(34).build(),
                Person.builder().name("Yesica").age(34).build(),
                Person.builder().name("Eluney").age(3).build(),
                Person.builder().name("Bishop").age(4).build(),
                Person.builder().name("Shina").age(1).build(),
                Person.builder().name("Lionel").age(10).build());

    persons.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));

    System.out.println(persons);
    }


}


@Data
@Builder
class  Person{
    private String name;
    private Integer age;
}
