package com.practice.leetcode;

import java.util.Arrays;

/*
1920. Build Array from Permutation
 */
public class BuildArray {
    public static void main(String[] args) {
        BuildArray ba = new BuildArray();
        int[] nums = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(ba.buildArray(nums)));
    }

    public int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[nums[i]];
        }

        return arr;
    }
}
