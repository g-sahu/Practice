package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. Majority Element II
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums) {
            int f = map.getOrDefault(n, 0) + 1;
            map.put(n, f);
        }

        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue() > nums.length/3) {
                list.add(e.getKey());
            }
        }

        return list;
    }
}
