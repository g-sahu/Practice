package com.practice.leetcode;

import java.util.Arrays;

/*
1929. Concatenation of Array
 */
public class ArrayConcatenation {

    public static void main(String[] args) {
        ArrayConcatenation ac = new ArrayConcatenation();
        int[] nums = {1,2,3};
        int[] concatenation = ac.getConcatenation(nums);
        System.out.println(Arrays.toString(concatenation));
    }

    public int[] getConcatenation(int[] nums) {
        int l = nums.length;
        int[] concat = new int[l*2];

        for (int i = 0; i < l; i++) {
            concat[i] = nums[i];
            concat[i+l] = nums[i];
        }

        return concat;
    }
}
