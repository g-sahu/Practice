package com.practice.leetcode;

import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int i=0, j=1;
        int c = 0;
        int k = 0;
        int l = nums.length;

        while(i < l && j < l) {
            if(nums[j] == nums[i]) {
                if(c == 1) {
                    nums[j] = Integer.MAX_VALUE;
                    k++;
                } else {
                    c++;
                }
                j++;
            } else {
                i = j;
                j = i+1;
                c = 0;
            }
        }

        Arrays.sort(nums);
        return l-k;
    }
}
