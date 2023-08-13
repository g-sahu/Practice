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
                {1,4}
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

        for (int[] row: intervals) {
            Arrays.sort(row);
        }

        List<int[]> merged = new ArrayList<>();
        int i = 1;

        while (i < l) {
            int[] prevRow = intervals[i-1];
            int[] currentRow = intervals[i];
            int start = prevRow[0];
            int end = prevRow[1];

            while (currentRow[0] <= end) {
                if (currentRow[1] > end) {
                    end = currentRow[1];
                }

                i++;

                if (i == l) {
                    break;
                }

                currentRow = intervals[i];
            }

            merged.add(new int[]{start, end});

            if (i == l-1) {
                merged.add(intervals[i]);
            }

            i++;
        }

        int[][] mergedIntervals = new int[merged.size()][2];
        for (int j = 0; j < merged.size(); j++) {
            mergedIntervals[j] = merged.get(j);
        }

        return mergedIntervals;
    }
}
