package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
2352. Equal Row and Column Pairs
 */
public class EqualRowColumnPairs {

    //Brute force
    public int equalPairs1(int[][] grid) {
        int n = grid.length;
        int c = 0;

        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                boolean isEqual = false;

                for (int k = 0; k < n; k++) {
                    if (row[k] == grid[k][j]) {
                        isEqual = true;
                    } else {
                        isEqual = false;
                        break;
                    }
                }

                if (isEqual) {
                    c++;
                }
            }
        }

        return c;
    }

    //Using HashMap
    public int equalPairs2(int[][] grid) {
        int l = grid.length;
        Map<String, Integer> map = new HashMap<>();

        for (int[] row : grid) {
            String key = Arrays.toString(row);
            int freq = map.getOrDefault(key, 0) + 1;
            map.put(key, freq);
        }

        int sum = 0;

        for (int j = 0; j < l; j++) {
            int[] col = new int[l];

            for (int i = 0; i < l; i++) {
                col[i] = grid[i][j];
            }

            String key = Arrays.toString(col);
            sum += map.getOrDefault(key, 0);
        }

        return sum;
    }
}
