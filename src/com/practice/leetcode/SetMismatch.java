package com.practice.leetcode;

/**
 * 645. Set Mismatch
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] x = new int[nums.length+1];
        int[] ans = new int[2];

        for (int j : nums) {
            if (x[j] == 0) {
                x[j] = j;
            } else {
                ans[0] = j;
            }
        }

        for(int i=1; i<x.length; i++) {
            if(x[i] == 0) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}
