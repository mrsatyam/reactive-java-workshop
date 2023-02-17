package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
        List<Integer> numbers = ReactiveSources.intNumbersFlux()
                .toStream()
                .toList();

        numbers.forEach(System.out::println);


        System.out.println("Press a key to end");

        List<List<Integer>> lists = List.of(List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 6, 7, 8));
        int sum = lists.stream().flatMap(nums -> nums.stream())
                .mapToInt(num -> num)
                .sum();
        System.out.println(sum);
    }

}
