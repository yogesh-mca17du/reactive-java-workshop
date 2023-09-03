package io.javabrains.reactiveworkshop;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("------------------------------------------------------");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("------------------------------------------------------");
        StreamSources.intNumbersStream()
                .filter(num -> num < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("------------------------------------------------------");
        List<Integer> integerList = StreamSources.intNumbersStream()
                .filter(num -> num > 5)
                .toList();
        System.out.println("Second : " + integerList.get(1) + ", Third : " + integerList.get(2));


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("------------------------------------------------------");
        Optional<Integer> optionalInteger = StreamSources.intNumbersStream()
                .filter(num -> num > 5)
                .findFirst();

        if (optionalInteger.isPresent()) System.out.println(optionalInteger.get());
        else System.out.println("-1");


        // Print first names of all users in userStream
        System.out.println("------------------------------------------------------");
        StreamSources.userStream()
                .forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("------------------------------------------------------");
        Set<Integer> integerSet = StreamSources.intNumbersStream().collect(Collectors.toSet());

        StreamSources.userStream()
                .filter(user -> integerSet.contains(user.getId()))
                .forEach(user -> System.out.println(user.getFirstName()));

    }

}
