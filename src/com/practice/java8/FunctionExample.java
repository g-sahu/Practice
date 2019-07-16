package com.practice.java8;

import java.math.BigDecimal;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        FunctionExample fex = new FunctionExample();
        fex.functionUsingInteger();
        fex.functionUsingBigDecimal();
    }

    private void functionUsingInteger() {
        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;

        // Returns 32
        System.out.println(times2.compose(squared).apply(4));

        // Returns 64
        System.out.println(times2.andThen(squared).apply(4));
    }

    private void functionUsingBigDecimal() {
        Function<BigDecimal, BigDecimal> times2 = e -> e.multiply(new BigDecimal(2));
        Function<BigDecimal, BigDecimal> squared = e -> e.multiply(e);

        // Returns 32
        System.out.println(times2.compose(squared).apply(new BigDecimal(4)));

        // Returns 64
        System.out.println(times2.andThen(squared).apply(new BigDecimal(4)));
    }
}