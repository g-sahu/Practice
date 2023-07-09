package com.practice.leetcode;

/*
    1351. Count Negative Numbers in a Sorted Matrix
    Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

    Example 1:
    Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
    Output: 8
    Explanation: There are 8 negatives number in the matrix.

    Example 2:
    Input: grid = [[3,2],[1,0]]
    Output: 0

    Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100
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
