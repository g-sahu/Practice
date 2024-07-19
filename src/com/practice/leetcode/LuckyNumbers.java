package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1380. Lucky Numbers in a Matrix
 */
public class LuckyNumbers {

    public List<Integer> luckyNumbers(int[][] m) {
        Set<Integer> min = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m.length; i++) {
            min.add(findMin(m, i));
        }

        for (int j = 0; j < m[0].length; j++) {
            int max = findMax(m, j);
            if (min.contains(max)) {
                list.add(max);
            }
        }

        return list;
    }

    int findMin(int[][] m, int r) {
        int min = m[r][0];
        for (int j = 0; j < m[0].length; j++) {
            min = Math.min(m[r][j], min);
        }

        return min;
    }

    int findMax(int[][] m, int c) {
        int max = m[0][c];
        for (int i = 0; i < m.length; i++) {
            max = Math.max(m[i][c], max);
        }

        return max;
    }
}
