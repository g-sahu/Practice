package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
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

    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (x, y) -> Integer.compare(x[0], y[0]));
        List<int[]> ans = new ArrayList<>();
        int[] prev = arr[0];

        for(int i=1; i<arr.length; i++) {
            int[] curr = arr[i];

            if(curr[0] <= prev[1]) {
                int end = Math.max(prev[1], curr[1]);
                prev[1] = end;
            } else {
                ans.add(prev);
                prev = curr;
            }
        }

        ans.add(prev);
        return ans.toArray(new int[ans.size()][]);
    }
}
