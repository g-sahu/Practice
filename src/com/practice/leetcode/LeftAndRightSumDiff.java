package com.practice.leetcode;

/**
 * 2574. Left and Right Sum Differences
 */
public class LeftAndRightSumDiff {

    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        int ls = 0, rs = 0;

        for (int num : nums) {
            rs += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rs = rs - nums[i];
            ans[i] = Math.abs(ls - rs);
            ls = ls + nums[i];
        }

        return ans;
    }
}
