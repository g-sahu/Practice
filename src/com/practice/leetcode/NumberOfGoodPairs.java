package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1512. Number of Good Pairs
 */
public class NumberOfGoodPairs {

    //Brute force
    public int numIdenticalPairs1(int[] nums) {
        int c = 0;

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] == nums[j]) {
                    c++;
                }
            }
        }

        return c;
    }

    public int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int c = 0;

        for (int num : nums) {
            int f = map.getOrDefault(num, 0);
            c += f;
            map.put(num, f + 1);
        }

        return c;
    }
}
