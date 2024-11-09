package com.practice.leetcode;

/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int t) {
        int p = findPivot(nums);
        int l = nums.length;

        if (p == 0) {
            return binarySearch(nums, 0, l - 1, t);
        }

        int i = binarySearch(nums, 0, p - 1, t);

        if (i == -1) {
            return binarySearch(nums, p, l - 1, t);
        } else {
            return i;
        }
    }

    private int binarySearch(int[] nums, int start, int end, int n) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (n == nums[mid]) {
                return mid;
            } else if (n < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int l = nums.length;
        if (l == 1 || nums[0] < nums[l - 1]) {
            return 0;
        }

        for (int i = 0; i < l - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }

}
