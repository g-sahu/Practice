package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
697. Degree of an Array
 */
public class DegreeOfAnArray {

    public static void main(String[] args) {

    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int n : nums) {
            int f = map.getOrDefault(n, 0) + 1;
            max = Math.max(max, f);
            map.put(n, f);
        }

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        int min = nums.length;

        for (int n : list) {
            int start = nums.length;
            int end = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == n) {
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            min = Math.min(min, end - start + 1);
        }

        return min;
    }
}
