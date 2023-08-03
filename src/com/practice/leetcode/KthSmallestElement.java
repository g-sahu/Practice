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
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };

        System.out.println(kse.kthSmallest2(grid, 8));
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
}
