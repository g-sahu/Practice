package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
189. Rotate Array
 */
public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        rotateArray.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int i = 0;
        int l = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        while (i < l) {
            k = k % l;
            int j = i + k;

            if (j >= l) {
                j = j - l;
            }

            int n = map.getOrDefault(i, nums[i]);
            map.put(j, nums[j]);
            nums[j] = n;
            i++;
        }
    }
}
