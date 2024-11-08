package com.practice.leetcode;

/**
 * 713. Subarray Product Less Than K
 */
public class SubarrayProductLessThanK {

    //Brute force
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = nums.length;
        int c = 0;

        for (int i = 0; i < l; i++) {
            int p = 1;

            for (int j = i; j < l; j++) {
                p *= nums[j];

                if (p >= k) {
                    break;
                }
                c++;
            }
        }

        return c;
    }

}
