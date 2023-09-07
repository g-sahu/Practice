package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
697. Degree of an Array
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int max = 0;

        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            int f = freq.getOrDefault(n, 0) + 1;
            max = Math.max(max, f);
            freq.put(n, f);
            left.putIfAbsent(n, i);
            right.put(n, i);
        }

        int min = nums.length;

        for(int n: freq.keySet()) {
            if(freq.get(n) == max) {
                min = Math.min(min, right.get(n) - left.get(n) + 1);
            }
        }

        return min;
    }
}
