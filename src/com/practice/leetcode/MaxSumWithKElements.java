package com.practice.leetcode;

import java.util.Arrays;

/*
2656. Maximum Sum With Exactly K Elements
 */
public class MaxSumWithKElements {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
    }

    //Using Sorting
    public int maximizeSum1(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 1; i <= k; i++) {
            int m = nums[nums.length-1];
            sum += m;
            nums[nums.length-1] = m+1;
        }

        return sum;
    }

    //By Sorting Math
    public int maximizeSum2(int[] nums, int k) {
        Arrays.sort(nums);
        return (nums[nums.length-1] * k) + (k * (k-1)/2);
    }
}
