package com.practice.leetcode;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 *
 * <p>Given an {@code m x n} matrix {@code grid}, which is sorted in non-increasing order both
 * row-wise and column-wise, return the number of negative numbers in {@code grid}.</p>
 *
 * <h2>Example 1</h2>
 * <pre>
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negative numbers in the matrix.
 * </pre>
 *
 * <h2>Example 2</h2>
 * <pre>
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * </pre>
 *
 * <h2>Constraints</h2>
 * <ul>
 *     <li>{@code m == grid.length}</li>
 *     <li>{@code n == grid[i].length}</li>
 *     <li>{@code 1 <= m, n <= 100}</li>
 *     <li>{@code -100 <= grid[i][j] <= 100}</li>
 * </ul>
 */
public class CountNegative {

    public static void main(String[] args) {
        CountNegative cn = new CountNegative();
        int[][] grid = {
                {3,2},
                {1,0}
        };

        System.out.println(cn.countNegatives(grid));
    }

    public int countNegatives(int[][] grid) {
        int i = grid.length - 1;
        int j = 0;
        int c = 0;

        while (i >= 0 && j < grid[0].length) {
            int[] arr = grid[i];
            int l = arr.length;

            while (j < l && arr[j] > -1) {
                j++;
            }

            c += l - j;
            i--;
        }

        return c;
    }
}
