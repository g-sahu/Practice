package com.practice.leetcode;

/**
 * 1470. Shuffle the Array
 */
public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int i = 0, j = n, x = 0;

        while(j < nums.length) {
            ans[x] = (x % 2 == 0) ? nums[i++] : nums[j++];
            x++;
        }

        return ans;
    }
}
