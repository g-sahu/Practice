package com.practice.leetcode;

/**
 * 289. Game of Life
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] ans = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int l=0;

                // Count live and dead neighbors
                for(int x=i-1; x<i+2; x++) {
                    for(int y=j-1; y<j+2; y++) {
                        if(x >= 0 && y >= 0 && x < m && y < n && (x != i || y != j)) {
                            if(board[x][y] == 1) {
                                l++;
                            }
                        }
                    }
                }

                if(board[i][j] == 1) {
                    ans[i][j] = (l == 2 || l == 3) ? 1 : 0;
                } else {
                    ans[i][j] = (l == 3) ? 1 : 0;
                }
            }
        }

        int i=0;
        for(int[] arr: ans) {
            board[i++] = arr;
        }
    }
}
