package com.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int factor = 2;

        list.stream()
            .map(e -> e * factor)
            .forEach(System.out :: println);

        //will cause compilation error
        //factor = 4;

        System.out.println();
        int[] factorArray = {2};

        Stream<Integer> stream = list.stream()
                                     .map(e -> e * factorArray[0]);

        factorArray[0] = 4;
        stream.forEach(System.out :: println);

        //Will throw IllegalStateException
        //stream.forEach(System.out :: println);
    }
}
