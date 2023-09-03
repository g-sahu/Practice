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

    public static void main(String[] args) {
        int[] nums1 = {54,93,21,73,84,60,18,62,59,89,83,89,25,39,41,55,78,27,65,82,94,61,12,38,76,5,35,6,51,48,61,0,47,60,84,9,13,28,38,21,55,37,4,67,64,86,45,33,41};
        int[] nums2 = {17,17,87,98,18,53,2,69,74,73,20,85,59,89,84,91,84,34,44,48,20,42,68,84,8,54,66,62,69,52,67,27,87,49,92,14,92,53,22,90,60,14,8,71,0,61,94,1,22,84,10,55,55,60,98,76,27,35,84,28,4,2,9,44,86,12,17,89,35,68,17,41,21,65,59,86,42,53,0,33,80,20};
        IntersectionOfArraysII o = new IntersectionOfArraysII();
        System.out.println(Arrays.toString(o.intersect3(nums1, nums2)));
    }

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

    //Using binary search
    public int[] intersect3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        List<Integer> list = new ArrayList<>();

        while (i < l1 && j < l2) {
            int x = Arrays.binarySearch(nums1, i, l1, nums2[j]);

            if (x >= 0) {
                while (x > i && nums1[x-1] == nums1[x]) {
                    x--;
                }
                list.add(nums2[j]);
                i = x+1;
            }
            j++;
        }

        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
}
