package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
350. Intersection of Two Arrays II
 */
public class IntersectionOfArraysII {

    //Using HashMap
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int n : nums1) {
            int freq = map.getOrDefault(n, 0) + 1;
            map.put(n, freq);
        }

        for (int n : nums2) {
            int v = map.getOrDefault(n, 0);

            if (v > 0) {
                list.add(n);
                map.put(n, --v);
            }
        }

        return list.stream()
                   .mapToInt(Integer :: intValue)
                   .toArray();
    }
}
