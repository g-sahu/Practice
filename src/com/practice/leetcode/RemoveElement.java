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
        System.out.println(re.removeElement2(nums, val));
    }

    //With sorting
    public int removeElement1(int[] nums, int val) {
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

    //Without sorting
    public int removeElement2(int[] nums, int val) {
        int l = nums.length;
        int i = 0;
        int j = l - 1;

        while (i < j){
            if (nums[i] == val) {
                while (j > i && nums[j] == val) {
                    j--;
                }

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }

            i++;
        }

        int k = 0;

        while (k < l && nums[k] != val) {
            k++;
        }

        return k;
    }
}
