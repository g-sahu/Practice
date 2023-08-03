package com.practice.leetcode;

import java.util.Arrays;

/*
378. Kth Smallest Element in a Sorted Matrix
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        KthSmallestElement kse = new KthSmallestElement();
        int[][] grid = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };

        System.out.println(kse.kthSmallest(grid, 8));
    }

    //Using array
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix.length;
        int[] nums = new int[l*l];
        int i = 0;

        for (int[] row: matrix) {
            for (int n: row) {
                nums[i++] = n;
            }
        }

        Arrays.sort(nums);
        return nums[k-1];
    }
}
