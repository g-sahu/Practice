package com.practice.leetcode;

import java.util.Arrays;

/*
268. Missing Number
 */
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] nums = {3,1,2,4};
        System.out.println(mn.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int totalSum = n * (n+1)/2;
        return totalSum - sum;
    }
}
