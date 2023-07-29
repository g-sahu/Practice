package com.practice.leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;

/*
66. Plus One
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] digits = {1,0,0};
        System.out.println(Arrays.toString(po.plusOne2(digits)));
    }

    //Using BigInteger
    public int[] plusOne1(int[] digits) {
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

        int size = stack.size();
        int[] digits = new int[size];
        int i = 0;

        while (!stack.isEmpty()) {
            digits[i++] = stack.pop();
        }

        return digits;
    }

    //Without BigInteger
    public int[] plusOne2(int[] digits) {
        int l = digits.length;
        Stack<Integer> stack = new Stack<>();
        int carry = 1;

        for (int i = l-1; i >= 0; i--) {
            int n = digits[i];

            if (n + carry == 10) {
                n = 0;
            } else {
                n = n + carry;
                carry = 0;
            }

            stack.push(n);
        }

        if (carry == 1) {
            stack.push(carry);
        }

        int size = stack.size();
        int[] arr = new int[size];
        int i = 0;

        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }

        return arr;
    }
}
