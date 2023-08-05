package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
378. Kth Smallest Element in a Sorted Matrix
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        KthSmallestElement kse = new KthSmallestElement();
        int[][] grid = {
                {1,3,5},
                {6,7,12},
                {11,14,14}
        };

        System.out.println(kse.kthSmallest3(grid, 6));
    }

    //Using array
    public int kthSmallest1(int[][] matrix, int k) {
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

    //Using Priority Queue
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int[] row: matrix) {
            for (int n: row) {
                if (pq.size() == k) {
                    if (n < pq.peek()) {
                        pq.poll();
                        pq.offer(n);
                    }
                } else {
                    pq.offer(n);
                }
            }
        }

        return pq.peek();
    }

    //Using Binary Search
    public int kthSmallest3(int[][] matrix, int k) {
        int l = matrix.length;

        if (l == 1) {
            return matrix[0][0];
        }

        int r = k / l;
        int c = k % l;

        if (c == 0) {
            c = l - 1;
            r--;
        } else {
            c--;
        }

        for (int i = 1; i < l; i++) {
            int[] nums = matrix[i-1];
            int n = matrix[i][0];

            if (n < nums[l-1]) {
                while (n < nums[l - 1]) {
                    int x = Arrays.binarySearch(nums, n);
                    x = Math.abs(x+1);
                    int temp = nums[x];
                    nums[x] = n;
                    matrix[i][0] = temp;
                }

                Arrays.sort(matrix[i]);
            }

            if (i == r+2) {
                break;
            }
        }

        return matrix[r][c];
    }
}
