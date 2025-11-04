package com.practice.leetcode;

/**
 * 540. Single Element in a Sorted Array
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid % 2 == 1) {
                mid--; // ensure mid is even
            }

            if (nums[mid] == nums[mid + 1]) {
                // left half is fine, go right
                low = mid + 2;
            } else {
                // single element is on left side
                high = mid;
            }
        }

        return nums[low];
    }
}
