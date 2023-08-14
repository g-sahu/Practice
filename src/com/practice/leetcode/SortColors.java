package com.practice.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
75. Sort Colors
 */
public class SortColors {
    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int k : arr) {
            int freq = map.getOrDefault(k, 0) + 1;
            map.put(k, freq);
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                arr[i] = entry.getKey();
                i++;
            }
        }
    }
}
