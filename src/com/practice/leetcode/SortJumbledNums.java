package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 2191. Sort the Jumbled Numbers
 */
public class SortJumbledNums {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int n = num;
            int val = 0;
            int j = 0;

            if (n == 0) {
                val = mapping[0];
            } else {
                while (n != 0) {
                    int r = n % 10;
                    val += Math.pow(10, j) * mapping[r];
                    n = n / 10;
                    j++;
                }
            }

            map.put(num, val);
        }

        Comparator<Integer> c = (a, b) -> Integer.compare(map.get(a), map.get(b));

        return Arrays.stream(nums)
                     .boxed()
                     .sorted(c)
                     .mapToInt(Integer :: intValue)
                     .toArray();
    }
}
