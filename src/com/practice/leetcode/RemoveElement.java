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
        int l = nums.length;
        int j = l - 1;
        int c = 0;

        for (int i = 0; i < l; i++) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                c++;
                j--;
            }
        }

        return l - c;
    }
}
