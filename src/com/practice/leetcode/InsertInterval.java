package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class InsertInterval {

    public int[][] insert(int[][] arr, int[] n) {
        if (arr.length == 0) {
            return new int[][]{n};
        }

        int[][] intervals = new int[arr.length + 1][2];
        boolean inserted = false;
        int i = 0;

        for (int[] row : arr) {
            if (!inserted && n[0] < row[0]) {
                intervals[i] = n;
                intervals[++i] = row;
                inserted = true;
            } else {
                intervals[i] = row;
            }
            i++;
        }

        if (!inserted) {
            intervals[i] = n;
        }

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();

        for (int[] row : intervals) {
            if (row[0] > end) {
                list.add(new int[]{start, end});
                start = row[0];
                end = row[1];
            } else {
                end = Math.max(end, row[1]);
            }
        }

        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }

}
