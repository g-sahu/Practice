package com.practice.leetcode;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = nums.length;

        if (l == 1 || nums[0] < nums[l - 1]) {
            return nums[0];
        }
        if (l == 2) {
            return nums[l - 1];
        }

        int start = 0, end = l - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid == 0 || mid == l - 1 || (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return Integer.MAX_VALUE;
    }

    //4,5,6,7,0,1,2
    public int findMin1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}
