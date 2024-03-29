package com.practice.leetcode;

import static com.practice.leetcode.LeetUtils.printMatrix;

/*
    867. Transpose Matrix
    Given a 2D integer array matrix, return the transpose of matrix.
    The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

    Example 1:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[1,4,7],[2,5,8],[3,6,9]]

    Example 2:
    Input: matrix = [[1,2,3],[4,5,6]]
    Output: [[1,4],[2,5],[3,6]]

    Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 1000
    1 <= m * n <= 105
    -109 <= matrix[i][j] <= 109
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        TransposeMatrix tm = new TransposeMatrix();
        int[][] matrix = {
                {1,2,3},
                {4,5,6}
        };

        int[][] tr = tm.transpose(matrix);
        printMatrix(tr);
    }

    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int[][] tr = new int[matrix[0].length][rows];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            for (int j = 0; j < row.length; j++) {
                tr[j][i] = matrix[i][j];
            }
        }

        return tr;
    }
}
