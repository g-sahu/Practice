package com.practice.leetcode;

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 */
public class NumsSmallerThanCurrent {

    //Brute Force
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            int c=0;

            for(int j=0; j<nums.length; j++) {
                if(i != j) {
                    if(nums[j] < nums[i]) {
                        c++;
                    }
                }
            }

            ans[i] = c;
        }

        return ans;
    }
}
