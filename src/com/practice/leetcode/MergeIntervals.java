package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
56. Merge Intervals
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };

        int[][] merge = mi.merge(intervals);
        LeetUtils.printMatrix(merge);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] row: intervals) {
            Arrays.sort(row);
        }

        List<int[]> list = new ArrayList<>();
        int i = 0;

        while (i < intervals.length - 1) {
            int[] currentRow = intervals[i];
            int[] nextRow = intervals[i+1];
            int start = currentRow[0];
            int end = currentRow[1];
            int j = 0;

            while (currentRow[1] > nextRow[0]) {
                end = nextRow[1];
                j++;
                currentRow = intervals[j];
                nextRow = intervals[j+1];
            }

            list.add(new int[]{start, end});
            i = j+1;
        }

        int[][] merge = new int[list.size()][2];

        for (int k = 0; k < list.size(); k++) {
            merge[k] = list.get(k);
        }

        return merge;
    }
}
