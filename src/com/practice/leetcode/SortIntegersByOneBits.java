package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
1356. Sort Integers by The Number of 1 Bits
 */
public class SortIntegersByOneBits {

    public int[] sortByBits1(int[] arr) {
        return Arrays.stream(arr)
                     .boxed()
                     .sorted(Comparator.comparingInt(this::countBits).thenComparing(Integer::intValue))
                     .mapToInt(Integer :: intValue)
                     .toArray();
    }

    private int countBits(int n) {
        int c = 0;
        while(n != 0) {
            if(n % 2 == 1) {
                c++;
            }
            n = n/2;
        }
        return c;
    }

    //Using built-in methods
    public int[] sortByBits2(int[] arr) {
        return Arrays.stream(arr)
                     .boxed()
                     .sorted(Comparator.comparingInt(Integer::bitCount).thenComparing(Integer::intValue))
                     .mapToInt(Integer :: intValue)
                     .toArray();
    }
}
