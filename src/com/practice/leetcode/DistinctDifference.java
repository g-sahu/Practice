package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctDifference {

    public static void main(String[] args) {
        int[] nums = {3,2,3,4,2};
        DistinctDifference d = new DistinctDifference();
        int[] diff = d.distinctDifferenceArray(nums);
        System.out.println(Arrays.toString(diff));
    }

    public int[] distinctDifferenceArray(int[] nums) {
        int l = nums.length;
        int[] diff = new int[l];
        Map<Integer, Integer> prefix = new HashMap<>();
        Map<Integer, Integer> suffix = freqMap(nums);

        for(int i=0; i<l; i++) {
            int s = suffix.get(nums[i]);

            if (s == 1) {
                suffix.remove(nums[i]);
            } else {
                suffix.put(nums[i], suffix.get(nums[i]) - 1);
            }

            int p = prefix.getOrDefault(nums[i], 0);
            prefix.put(nums[i], p+1);
            diff[i] = prefix.size() - suffix.size();
        }

        return diff;
    }

    private static Map<Integer, Integer> freqMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: nums) {
            int newVal = map.getOrDefault(n, 0) + 1;
            map.put(n, newVal);
        }

        return map;
    }
}
