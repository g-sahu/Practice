package com.practice.leetcode;

import java.util.Arrays;

/*
88. Merge Sorted Array
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] nums1 = {1,2,3,5,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 4;
        int n = 3;
        msa.merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    //Using Sorting
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    //Using array
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int c = 0;
        int[] nums = new int[m+n];

        while (c < m + n) {
            if (i >= m) {
                nums[c] = nums2[j];
                j++;
            } else if (j >= n || nums1[i] <= nums2[j]) {
                nums[c] = nums1[i];
                i++;
            } else {
                nums[c] = nums2[j];
                j++;
            }

            c++;
        }

        System.arraycopy(nums, 0, nums1, 0, m+n);
    }
}
