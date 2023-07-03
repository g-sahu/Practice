package com.practice.leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {4, 5};
        int val = 5;
        RemoveElement rm = new RemoveElement();
        System.out.println("k = " + rm.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int size = nums.length;

        if(size == 0) {
            return 0;
        }

        int i = 0;
        int j = size - 1;

        if (i == j) {
            return nums[i] == val ? 0 : 1;
        }

        while (i < j) {
            if (nums[i] == val) {
                while (j > i && nums[j] == val) {
                    j--;
                }

                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j--;
            }

            i++;
        }

        System.out.println("nums = " + Arrays.toString(nums));
        return j + 1;
    }
}
