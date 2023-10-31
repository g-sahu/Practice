package com.practice.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * 436. Find Right Interval
 */
public class FindRightInterval {

    public int[] findRightInterval(int[][] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i][0], i);
        }

        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            Map.Entry<Integer, Integer> next = map.ceilingEntry(nums[i][1]);
            ans[i] = next == null ? -1 : next.getValue();
        }

        return ans;
    }
}
