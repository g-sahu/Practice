package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
169. Majority Element
 */
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {};
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int val = map.getOrDefault(num, 0) + 1;
            map.put(num, val);
        }

        return map.entrySet()
                  .stream()
                  .filter(entry -> entry.getValue() > nums.length / 2)
                  .findFirst()
                  .get()
                  .getKey();
    }

}
