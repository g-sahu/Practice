package com.practice.leetcode;

import java.util.Arrays;

/*
1365. How Many Numbers Are Smaller Than the Current Number
 */
public class SmallerNumbers {
    public static void main(String[] args) {
        SmallerNumbers sn = new SmallerNumbers();
        int[] nums = {6,5,4,8};
        int[] arr = sn.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(arr));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int c = 0;

            for (int num : nums) {
                if (nums[i] > num) {
                    c++;
                }
            }

            arr[i] = c;
        }

        return arr;
    }
}
