package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
349. Intersection of Two Arrays
 */
public class IntersectionOfTwoArrays {

    //Using HashSet
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int j : nums1) {
            set.add(j);
        }

        for (int j : nums2) {
            if (set.contains(j)) {
                ans.add(j);
                set.remove(j);
            }
        }

        int[] arr = new int[ans.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(i);
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
