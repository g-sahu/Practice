package com.practice.leetcode;

import java.util.Arrays;

/*
167. Two Sum II - Input Array Is Sorted
 */
public class TwoSumII {

    //Using Binary Search
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = Arrays.binarySearch(numbers, target - numbers[i]);

            if (j >= 0 && i != j) {
                int[] ans = new int[]{i + 1, j + 1};
                Arrays.sort(ans); //Added because LC won't accept unsorted indexes
                return ans;
            }
        }

        return null;
    }

    //Using Two Pointer
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i != j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return null;
    }
}
