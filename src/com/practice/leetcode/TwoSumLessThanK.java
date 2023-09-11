package com.practice.leetcode;

import java.util.Arrays;

/*
1099. Two Sum Less Than K
 */
public class TwoSumLessThanK {

    //Using Two Pointers
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length -1;
        int max = -1;

        while(l < r) {
            int sum = nums[l] + nums[r];

            if(sum >= k) {
                r--;
            } else {
                max = Math.max(max, sum);
                l++;
            }
        }

        return max;
    }
}
