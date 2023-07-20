package com.practice.leetcode;

import java.util.Arrays;

/*
2357. Make Array Zero by Subtracting Equal Amounts
 */
public class MakeArrayZero {
    public static void main(String[] args) {
        MakeArrayZero maz = new MakeArrayZero();
        int[] nums = {1,5,0,3,5};
        System.out.println(maz.minimumOperations(nums));
    }

    public int minimumOperations(int[] nums) {
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
}
