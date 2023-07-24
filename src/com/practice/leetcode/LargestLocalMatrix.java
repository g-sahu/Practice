package com.practice.leetcode;

import static com.practice.leetcode.LeetUtils.printMatrix;

/*
2373. Largest Local Values in a Matrix
 */
public class LargestLocalMatrix {
    public static void main(String[] args) {
        LargestLocalMatrix llm = new LargestLocalMatrix();
        int[][] grid = {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,2,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };

        int[][] result = llm.largestLocal(grid);
        printMatrix(result);
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n-2][n-2];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                result[i-1][j-1] = largestLocal(grid, i, j);
            }
        }

        return result;
    }

    private int largestLocal(int[][] grid, int i, int j) {
        int largest = 0;

        for (int k = i-1; k <= i+1 ; k++) {
            for (int l = j-1; l <= j+1 ; l++) {
                largest = grid[k][l] > largest ? grid[k][l] : largest;
            }
        }

        return largest;
    }
}
