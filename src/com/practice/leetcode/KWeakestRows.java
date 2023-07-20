package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
1337. The K Weakest Rows in a Matrix
 */
public class KWeakestRows {

    public static void main(String[] args) {
        KWeakestRows kwr = new KWeakestRows();
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };

        int[] rows = kwr.kWeakestRows(grid, 3);
        System.out.println(Arrays.toString(rows));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            int sum = findSum(mat[i]);
            pq.offer(sum);
            List<Integer> list = map.containsKey(sum) ? map.get(sum) : new ArrayList<>();
            list.add(i);
            map.put(sum, list);
        }

        int[] indices = new int[k];

        for (int i = 0; i < k; i++) {
            List<Integer> list = map.get(pq.poll());
            indices[i] = list.remove(0);
        }

        return indices;
    }

    private int findSum(int[] arr) {
        int c = 0;
        for (int n: arr) {
            if (n == 1) {
                c++;
            } else {
                break;
            }
        }

        return c;
    }
}
