package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2870. Minimum Number of Operations to Make Array Empty
 */
public class MinOpsToMakeArrayEmpty {

    public static void main(String[] args) {
        MinOpsToMakeArrayEmpty o = new MinOpsToMakeArrayEmpty();
        int[] nums = {2,1,2,2,3,3};
        System.out.println(o.minOperations(nums));
    }

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int f = map.getOrDefault(num, 0) + 1;
            map.put(num, f);
        }

        int c = 0;

        for (int n: map.values()) {
            if (n == 1) {
                return -1;
            }
            c += countOps(n);
        }

        return c;
    }

    private int countOps(int n) {
        int d = n/3;
        int r = n%3;

        if (r == 0) {
            return d;
        }
        return d+1;
    }
}
