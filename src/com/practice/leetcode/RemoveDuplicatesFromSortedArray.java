package com.practice.leetcode;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i=0, j=1, k=0;
        int l = nums.length;

        while(i < l && j < l) {
            if(nums[j] == nums[i]) {
                nums[j++] = 101;
                k++;
            } else {
                i = j;
                j = i+1;
            }
        }

        Arrays.sort(nums);
        return l-k;
    }
}
