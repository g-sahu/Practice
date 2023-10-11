package com.practice.leetcode;

/**
 * 209. Minimum Size Subarray Sum
 */
public class MinimumSubArray {
    public static void main(String[] args) {
        MinimumSubArray ms = new MinimumSubArray();
        int k = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(ms.minSubArrayLen(k, nums));
    }

    public int minSubArrayLen(int k, int[] nums) {
        int i=0, j=0;
        int sum=0, min=Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= k) {
                min = Math.min(min, j-i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
