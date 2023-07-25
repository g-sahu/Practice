package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
136. Single Number
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] nums = {4,1,2,1,2};
        System.out.println(sn.singleNumber2(nums));
    }

    //Using extra space
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.iterator().next();
    }

    //Without using extra space
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;

        for (int i = 0; i < l-1; i+=2) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }

        return nums[l-1];
    }
}
