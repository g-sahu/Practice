package com.practice.leetcode;

import java.util.Arrays;

/*
27. Remove Element
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        //0,0,1,2,2,2,3,4
        int val = 2;
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int i = 0;
        int j = -1;
        int l = nums.length;
        int c = 0;

        while (i < l) {
            if (nums[i] == val) {
                j = j == -1 ? i : j;
                c++;
            }

            i++;
        }

        int k = l - c;

        for (int m = 1; m <= c; m++) {
            nums[j] = nums[l - 1];
            j++;
            l--;
        }

        return k;
    }
}
