package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
169. Majority Element
 */
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {1,1,1,1,1,2,2,3};
        System.out.println(me.majorityElement2(nums));
    }

    //Using HashMap
    public int majorityElement1(int[] nums) {
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

    //Using Sorting
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
