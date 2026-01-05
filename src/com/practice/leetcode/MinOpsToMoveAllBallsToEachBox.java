package com.practice.leetcode;

/**
 * 1769. Minimum Number of Operations to Move All Balls to Each Box
 */
public class MinOpsToMoveAllBallsToEachBox {

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        int balls = 0;
        int moves = 0;

        // Left → Right
        for (int i = 0; i < n; i++) {
            result[i] += moves;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            moves += balls;
        }

        balls = 0;
        moves = 0;

        // Right → Left
        for (int i = n - 1; i >= 0; i--) {
            result[i] += moves;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            moves += balls;
        }

        return result;
    }

}
