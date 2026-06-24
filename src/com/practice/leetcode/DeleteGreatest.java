package com.practice.leetcode;

import java.util.Arrays;

/**
 * 2500. Delete Greatest Value in Each Row
 *
 * <p>You are given an {@code m x n} matrix {@code grid} consisting of positive integers.</p>
 *
 * <p>Perform the following operation until {@code grid} becomes empty:</p>
 *
 * <ul>
 *     <li>Delete the element with the greatest value from each row. If multiple such elements
 *     exist, delete any of them.</li>
 *     <li>Add the maximum of deleted elements to the answer.</li>
 * </ul>
 *
 * <p>Note that the number of columns decreases by one after each operation. Return the answer after
 * performing the operations described above.</p>
 *
 * <h2>Example 1</h2>
 * <pre>
 * Input: grid = [[1,2,4],[3,3,1]]
 * Output: 8
 * Explanation: The diagram above shows the removed values in each step.
 * - In the first operation, we remove 4 from the first row and 3 from the second row.
 *   There are two cells with value 3, and we can remove any of them. We add 4 to the answer.
 * - In the second operation, we remove 2 from the first row and 3 from the second row.
 *   We add 3 to the answer.
 * - In the third operation, we remove 1 from the first row and 1 from the second row.
 *   We add 1 to the answer.
 * The final answer = 4 + 3 + 1 = 8.
 * </pre>
 *
 * <h2>Example 2</h2>
 * <pre>
 * Input: grid = [[10]]
 * Output: 10
 * Explanation: The diagram above shows the removed values in each step.
 * - In the first operation, we remove 10 from the first row. We add 10 to the answer.
 * The final answer = 10.
 * </pre>
 *
 * <h2>Constraints</h2>
 * <ul>
 *     <li>{@code m == grid.length}</li>
 *     <li>{@code n == grid[i].length}</li>
 *     <li>{@code 1 <= m, n <= 50}</li>
 *     <li>{@code 1 <= grid[i][j] <= 100}</li>
 * </ul>
 */
public class DeleteGreatest {

    public static void main(String[] args) {
        DeleteGreatest dg = new DeleteGreatest();
        int[][] grid = {
                {1,2,4},
                {3,3,1}
        };

        System.out.println(dg.deleteGreatestValue(grid));
    }

    public int deleteGreatestValue(int[][] grid) {
        for (int[] arr : grid) {
            Arrays.sort(arr);
        }

        int sum = 0;

        for (int j = grid[0].length - 1; j >= 0; j--) {
            int max = -1;

            for (int[] arr : grid) {
                max = arr[j] > max ? arr[j] : max;
            }

            sum += max;
        }

        return sum;
    }
}
