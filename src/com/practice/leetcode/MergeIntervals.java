package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
56. Merge Intervals
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {
                {1,4},
                {4,5}
        };

        int[][] merge = mi.merge(intervals);
        LeetUtils.printMatrix(merge);
    }

    public int[][] merge(int[][] intervals) {
        int l = intervals.length;

        if (l < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int i = 1;
        int start = intervals[0][0];
        int end = intervals[0][1];

        while (i < l) {
            int[] currentRow = intervals[i];

            if (end < currentRow[0]) {
                merged.add(new int[]{start, end});
                start = currentRow[0];
                end = currentRow[1];
            } else if (end < currentRow[1]) {
                end = currentRow[1];
            }

            if (i == l-1) {
                merged.add(new int[]{start, end});
            }

            i++;
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
