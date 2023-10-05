package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1150. Check If a Number Is Majority Element in a Sorted Array
 */
public class CheckMajorityElement {

    //Using HashMap
    public boolean isMajorityElement1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums) {
            int f = map.getOrDefault(n, 0) + 1;
            map.put(n, f);
        }

        return map.getOrDefault(target, 0) > nums.length/2;
    }

    //Using Binary Search
    public boolean isMajorityElement2(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);

        if (i < 0) {
            return false;
        }

        int c = 1;
        int l = i - 1;
        int r = i + 1;

        while (l >= 0 && nums[l--] == nums[i]) {
            c++;
        }

        while (r < nums.length && nums[r++] == nums[i]) {
            c++;
        }

        return c > nums.length / 2;
    }
}
