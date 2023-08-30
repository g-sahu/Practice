package com.practice.leetcode;

/*
2352. Equal Row and Column Pairs
 */
public class EqualRowColumnPairs {

    //Brute force
    public int equalPairs(int[][] grid) {
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
}
