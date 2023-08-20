package com.practice.leetcode;

import java.util.Arrays;
import java.util.List;

/*
2824. Count Pairs Whose Sum is Less than Target
 */
public class CountPairs {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-1,1,2,3,1);
        CountPairs lc = new CountPairs();
        System.out.println(lc.countPairs(nums, 2));
    }

    public int countPairs(List<Integer> nums, int target) {
        int c = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    c++;
                }
            }
        }

        return c;
    }
}
