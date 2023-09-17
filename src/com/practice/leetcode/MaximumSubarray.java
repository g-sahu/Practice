package com.practice.leetcode;

/*
53. Maximum Subarray
 */
public class MaximumSubarray {

    //Optimised Brute-force
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<l; i++) {
            int sum = 0;

            for(int j=i; j<l; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
