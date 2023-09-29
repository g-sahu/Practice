package com.practice.leetcode;

/**
 * 905. Sort Array By Parity
 */
public class SortArrayByParity {

    //Brute force
    public int[] sortArrayByParity1(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 != 0) {
                for(int j=i+1; j<nums.length; j++) {
                    if(nums[j] %2 == 0) {
                        int t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                    }
                }
            }
        }

        return nums;
    }

    //Two pointers
    public int[] sortArrayByParity2(int[] nums) {
        int l=0, r= nums.length-1;

        while (l < r) {
            if (nums[l] % 2 != 0) {
                if (nums[r] %2 == 0) {
                    int t = nums[l];
                    nums[l] = nums[r];
                    nums[r] = t;
                    l++;
                } else {
                    r--;
                }
            } else {
                l++;
            }
        }

        return nums;
    }
}
