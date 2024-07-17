package com.practice.leetcode;

/**
 * 1827. Minimum Operations to Make the Array Increasing
 */
public class MinOpsToMakeArrayInc {

    public int minOperations(int[] nums) {
        int sum = 0;

        for (int i=0; i<nums.length-1; i++) {
            if(nums[i+1] <= nums[i]) {
                int diff = nums[i] - nums[i+1];
                sum += diff + 1;
                nums[i+1] += diff + 1;
            }
        }

        return sum;
    }
}
