package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
349. Intersection of Two Arrays
 */
public class IntersectionOfTwoArrays {

    //Using HashSet
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                ans.add(i);
            }
        }

        int[] arr = new int[ans.size()];
        int i = 0;
        for (int n: ans) {
            arr[i++] = n;
        }
        return arr;
    }

    //Using Sorting and Two Pointers
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        Set<Integer> set = new HashSet<>();

        while (i < l1 && j < l2) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] arr = new int[set.size()];
        int k = 0;
        for (int n : set) {
            arr[k++] = n;
        }
        return arr;
    }
}
