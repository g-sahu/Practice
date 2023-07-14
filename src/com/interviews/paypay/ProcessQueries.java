package com.interviews.paypay;

import java.util.Arrays;

/*
Consider a rectangular h × w board with all cells initially white. You are to process several queries of the following types:

"x a b" - color the white cell (a, b) (0-based coordinates, the first one is a row index, and the second one is a column index) black;
"> a b" - find the leftmost white cell to the right of the white cell (a, b);
"< a b" - find the rightmost white cell to the left of the white cell (a, b);
"v a b" - the same, but the search should be done downwards;
"^ a b" - the same, but the search should be done upwards;
For each query, except the ones of the first type, find the answer.

Example

For h = 3, w = 5, and
queries = ["v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0"],
the output should be
solution(h, w, queries) = [[2, 2], [-1, -1], [2, 3], [2, 4], [-1, -1]].

Check out the image above to see the state of the board after each query of the first type:


Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] integer h

A positive integer.

Guaranteed constraints:
1 ≤ h ≤ 500.

[input] integer w

A positive integer.

Guaranteed constraints:
1 ≤ w ≤ 500.

[input] array.string queries

Queries in the above-described format.

Guaranteed constraints:
5 ≤ queries.length ≤ 104.

[output] array.array.integer

For each query except the ones of the first type, store the answer's coordinates in the array. If the desired cell doesn't exist, store [-1, -1] instead. The answers should be stored in the same order as the queries.
 */
public class ProcessQueries {
    public static void main(String[] args) {
        ProcessQueries pq = new ProcessQueries();
        String[] queries = {"x 0 10",
                "^ 12 10",
                "^ 0 7",
                "> 15 11",
                "v 5 1",
                "^ 5 2",
                "v 14 22",
                "^ 10 17",
                "x 4 16",
                "x 3 14",
                "x 4 20",
                "v 3 19",
                "x 5 11",
                "x 14 9",
                "< 6 13",
                "^ 2 17",
                "^ 1 11",
                "< 8 21",
                "v 12 18",
                "< 12 19",
                "> 6 23",
                "x 16 1",
                "v 12 16",
                "v 9 17",
                "< 7 13",
                "< 15 3",
                "v 15 10",
                "x 1 2",
                "x 12 2",
                "< 0 4",
                "> 15 21",
                "< 6 23",
                "v 8 5",
                "> 0 17",
                "x 0 9",
                "< 15 21",
                "x 9 3",
                "v 15 1",
                "> 10 2",
                "> 13 18",
                "x 7 14",
                "x 4 18",
                "v 11 19",
                "> 11 3",
                "> 12 17",
                "x 16 19",
                "^ 10 22",
                "x 6 18",
                "x 12 6",
                "< 14 6"};
        int[][] res = pq.solution(17, 24, queries);
        for (int[] r: res) {
            System.out.println(Arrays.toString(r));
        }
    }

    int[][] solution(int h, int w, String[] queries) {
        int[][] grid = new int[h][w];
        int[][] ans = new int[queries.length][2];
        int k = 0;

        for (String q: queries) {
            String[] split = q.split(" ");
            String op = split[0];
            int i = Integer.parseInt(split[1]);
            int j = Integer.parseInt(split[2]);

            switch (op) {
                case "x":
                    grid[i][j] = 1;
                    break;
                case ">":
                    ans[k] = findRight(grid, i, j);
                    k++;
                    break;
                case "<":
                    ans[k] = findLeft(grid, i, j);
                    k++;
                    break;
                case "v":
                    ans[k] = findDown(grid, i, j);
                    k++;
                    break;
                case "^":
                    ans[k] = findUp(grid, i, j);
                    k++;
                    break;
            }
        }

        int[][] res = new int[k][2];
        System.arraycopy(ans, 0, res, 0, k);
        return res;
    }

    private static int[] getAns(int i, int j, int rows, int cols) {
        int[] ans = new int[2];

        if (i >= rows || i < 0 || j >= cols || j < 0) {
            ans[0] = -1;
            ans[1] = -1;
        } else {
            ans[0] = i;
            ans[1] = j;
        }

        return ans;
    }

    private int[] findRight(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        j = j + 1;

        while (j < cols) {
            if (grid[i][j] == 0) {
                break;
            }
            j++;
        }

        return getAns(i, j, rows, cols);
    }

    private int[] findLeft(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        j = j - 1;

        while (j >= 0) {
            if (grid[i][j] == 0) {
                break;
            }
            j--;
        }

        return getAns(i, j, rows, cols);
    }

    private int[] findDown(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        i = i + 1;

        while (i < rows) {
            if (grid[i][j] == 0) {
                break;
            }
            i++;
        }

        return getAns(i, j, rows, cols);
    }

    private int[] findUp(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        i = i - 1;

        while (i >= 0) {
            if (grid[i][j] == 0) {
                break;
            }
            i--;
        }

        return getAns(i, j, rows, cols);
    }
}
