package com.practice.leetcode;

/*
2367. Number of Arithmetic Triplets
 */
public class ArithmeticTriplets {
    public static void main(String[] args) {
        ArithmeticTriplets at =  new ArithmeticTriplets();
        int[] nums = {4,5,6,7,8,9};
        int diff = 2;
        System.out.println(at.arithmeticTriplets(nums, diff));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int l = nums.length;
        int c = 0;

        for (int i = 0; i < l - 2; i++) {
            for (int j = i+1; j < l - 1; j++) {
                if (nums[j] - nums[i] != diff) {
                    continue;
                }

                for (int k = j + 1; k < l; k++) {
                    if (nums[k] - nums[j] == diff) {
                        c++;
                    }
                }
            }
        }

        return c;
    }
}
