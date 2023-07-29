package com.practice.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
66. Plus One
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] digits = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        System.out.println(Arrays.toString(po.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        BigInteger num = numFromDigits(digits);
        num = num.add(BigInteger.ONE);
        return numToDigits(num);
    }

    private BigInteger numFromDigits(int[] digits) {
        BigInteger num = BigInteger.ZERO;

        for (int digit : digits) {
            num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(digit));
        }

        return num;
    }

    private int[] numToDigits(BigInteger num) {
        Stack<Integer> stack = new Stack<>();

        while (!num.equals(BigInteger.ZERO)) {
            stack.add(num.mod(BigInteger.TEN).intValue());
            num = num.divide(BigInteger.TEN);
        }

        List<Integer> digits = new ArrayList<>();

        while (!stack.isEmpty()) {
            digits.add(stack.pop());
        }

        return digits.stream()
                     .mapToInt(Integer :: intValue)
                     .toArray();
    }
}
