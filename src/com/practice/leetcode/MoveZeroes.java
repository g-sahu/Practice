package com.practice.leetcode;

import java.util.Arrays;

/*
283. Move Zeroes
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = {0,0,8,0,9,5,0,1};
        mz.moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    //Using two pointers
    public void moveZeroes1(int[] nums) {
        int l = nums.length;

        for (int i = 0; i < l; i++) {
            if (nums[i] == 0) {
                int j = i;
                int k = j + 1;

                while (k < l) {
                    if (nums[k] != 0) {
                        int temp = nums[j];
                        nums[j] = nums[k];
                        nums[k] = temp;
                        j = k;
                    }

                    k++;
                }

                l = j;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
