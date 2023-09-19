package com.practice.leetcode;

/*
495. Teemo Attacking
 */
public class TeemoAttacking {

    public int findPoisonedDuration(int[] nums, int d) {
        int start = nums[0];
        int end = nums[0] + d;
        int p = 0;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > end) {
                p += end - start;
                start = nums[i];
            }
            end = nums[i] + d;
        }

        p += end-start;
        return p;
    }
}
