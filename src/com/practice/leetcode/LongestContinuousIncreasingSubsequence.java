package com.practice.leetcode;

/*
674. Longest Continuous Increasing Subsequence
 */
public class LongestContinuousIncreasingSubsequence {

    //Brute force
    public int findLengthOfLCIS1(int[] nums) {
        int max = 1;

        for(int i=0; i<nums.length; i++) {
            int l = 1;

            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] > nums[j-1]) {
                    l++;
                } else {
                    break;
                }
            }
            max = Math.max(max, l);
        }

        return max;
    }

    //Two Pointers
    public int findLengthOfLCIS2(int[] nums) {
        int i=0, j=1;
        int l = nums.length;
        int max = 1;

        while(i < l && j < l) {
            if(nums[j] > nums[j-1]) {
                max = Math.max(max, j-i+1);
                j++;
            } else {
                i = j;
                j = i+1;
            }
        }

        return max;
    }
}
