package com.practice.leetcode;

/**
 * 1646. Get Maximum in Generated Array
 */
public class GetMaximumInGeneratedArray {

    public int getMaximumGenerated(int n) {
        if(n == 0) {
            return 0;
        }

        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;

        for(int i=1; i<=n/2; i++) {
            int x = 2 * i;

            if(2 <= x && x <= n) {
                nums[x] = nums[i];
            }

            if(2 <= x+1 && x+1 <= n) {
                nums[x+1] = nums[i] + nums[i+1];
            }
        }

        int max = 0;

        for(int x: nums) {
            max = Math.max(max, x);
        }

        return max;
    }
}
