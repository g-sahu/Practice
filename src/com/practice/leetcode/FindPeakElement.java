package com.practice.leetcode;

/*
162. Find Peak Element
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        FindPeakElement fpe = new FindPeakElement();
        System.out.println(fpe.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int last = nums.length-1;

        if (last == 0) {
            return 0;
        }

        int left = 0;
        int right = last;

        while (left <= right) {
            int mid = (left + right)/2;

            if (mid == 0) {
                if (nums[mid] > nums[mid+1]) {
                    return mid;
                } else {
                    left = mid+1;
                }
            } else if (mid == last) {
                if (nums[mid] > nums[mid-1]) {
                    return mid;
                } else {
                    right = mid-1;
                }
            } else if (nums[mid] > nums[mid+1]) {
                if (nums[mid] > nums[mid-1]) {
                    return mid;
                } else {
                    right = mid-1;
                }
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}
