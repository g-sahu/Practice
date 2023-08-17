package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
2215. Find the Difference of Two Arrays
 */
public class DiffOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        for (int num: nums1) {
            set2.remove(num);
        }

        for (int num: nums2) {
            set1.remove(num);
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(set1));
        list.add(new ArrayList<>(set2));
        return list;
    }
}
