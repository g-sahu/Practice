package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = intervals.length;
        int[][] arr = new int[l+1][];
        int idx = l;

        if(l == 0) {
            return new int[][]{newInterval};
        }

        for(int i=0; i<l; i++) {
            int[] curr = intervals[i];

            if(curr[0] < newInterval[0]) {
                arr[i] = curr;
            } else {
                idx = Math.min(idx, i);
                arr[i+1] = curr;
            }
        }

        arr[idx] = newInterval;
        int[] prev = arr[0];
        List<int[]> list = new ArrayList<>();

        for(int i=1; i<arr.length; i++) {
            int[] curr = arr[i];

            if(curr[0] <= prev[1]) {
                int end = Math.max(prev[1], curr[1]);
                prev[1] = end;
            } else {
                list.add(prev);
                prev = curr;
            }
        }

        list.add(prev);
        return list.toArray(new int[list.size()][]);
    }

}
