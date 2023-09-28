package com.practice.leetcode;

/**
 * 905. Sort Array By Parity
 */
public class SortArrayByParity {

    //Brute force
    public int[] sortArrayByParity(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 != 0) {
                for(int j=i+1; j<nums.length; j++) {
                    if(nums[j] %2 == 0) {
                        int t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                    }
                }
            }
        }

        return nums;
    }
}
