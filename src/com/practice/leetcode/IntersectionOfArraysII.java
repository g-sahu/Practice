package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
350. Intersection of Two Arrays II
 */
public class IntersectionOfArraysII {

    //Using HashMap
    public int[] intersect1(int[] nums1, int[] nums2) {
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

    //Using two pointers
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        List<Integer> list = new ArrayList<>();

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
