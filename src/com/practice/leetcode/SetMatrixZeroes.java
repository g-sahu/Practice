package com.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
73. Set Matrix Zeroes
 */
public class SetMatrixZeroes {

    //Using extra space
    public void setZeroes(int[][] matrix) {
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
}
