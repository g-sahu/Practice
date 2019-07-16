package com.practice.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MethodReferences {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.forEach(i -> System.out.print(i));
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();

        Map<Integer, Integer> map = new HashMap<>();
        list.forEach(k -> map.put(k, k));
        map.forEach((k, v) -> System.out.println(k + " -> " + v));


        System.out.println(
                list.stream()
                    .mapToInt(e -> e)
                    .sum()
        );

        System.out.println(
                list.stream()
                .reduce(0, (a, b) -> a + b)
        );

        Function function;
    }
}
