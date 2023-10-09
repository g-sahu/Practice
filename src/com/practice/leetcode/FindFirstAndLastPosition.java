package com.practice.leetcode;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int x = Arrays.binarySearch(nums, target);

        if (x < 0) {
            return new int[]{-1, -1};
        }

        int l = x;
        int start = x;

        while (l >= 0 && nums[l] == nums[x]) {
            start = l;
            l = Arrays.binarySearch(nums, 0, l, target);
        }

        int r = x;
        int end = x;

        while (r >= 0 && r < nums.length && nums[r] == nums[x]) {
            end = r;
            r = Arrays.binarySearch(nums, r + 1, nums.length, target);
        }

        return new int[]{start, end};
    }
}
