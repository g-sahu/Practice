package com.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
73. Set Matrix Zeroes
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
    }

    //Using extra space
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < m; i++) {
            boolean flag = false;
            int[] row = matrix[i];

            for (int j = 0; j < n; j++) {
                if (row[j] == 0) {
                    flag = true;
                    cols.add(j);
                }
            }

            if (flag) {
                matrix[i] = new int[n];
            }
        }

        for (int col : cols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        boolean col0 = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = rows-1; i >= 0; i--) {
            for (int j = cols-1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) {
                matrix[i][0] = 0;
            }
        }
    }
}
