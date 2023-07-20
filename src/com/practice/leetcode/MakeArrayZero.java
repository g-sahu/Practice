package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
2357. Make Array Zero by Subtracting Equal Amounts
 */
public class MakeArrayZero {
    public static void main(String[] args) {
        MakeArrayZero maz = new MakeArrayZero();
        int[] nums = {1,5,0,3,5};
        System.out.println(maz.minimumOperations3(nums));
    }

    //Using sorting
    public int minimumOperations1(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int c = 0;

        for (int i = 0; i < l; i++) {
            int j = i;

            if (nums[i] != 0) {
                int s = nums[i];

                while (j < l) {
                    nums[j] = nums[j] - s;
                    j++;
                }

                c++;
            }
        }

        return c;
    }

    //Using HashMap
    public int minimumOperations2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            if (num != 0) {
                int freq = map.getOrDefault(num, 0) + 1;
                map.put(num, freq);
            }
        }

        return map.keySet().size();
    }

    //Using Set
    public int minimumOperations3(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            if (num != 0) {
                set.add(num);
            }
        }

        return set.size();
    }
}
