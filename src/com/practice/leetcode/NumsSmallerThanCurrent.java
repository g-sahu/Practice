package com.practice.leetcode;

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 */
public class NumsSmallerThanCurrent {

    //Brute Force
    public int[] smallerNumbersThanCurrent_1(int[] nums) {
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

    //Counting Sort
    public int[] smallerNumbersThanCurrent_2(int[] nums) {
        int[] count = new int[102];

        for(int n: nums) {
            count[n+1]++;
        }

        for(int i=1; i<count.length; i++) {
            count[i] += count[i-1];
        }

        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            ans[i] = count[nums[i]];
        }

        return ans;
    }
}
