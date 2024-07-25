package com.practice.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {15,7,3,8,6,1,23,14,18};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] nums) {
        int l = nums.length;

        while(l > 0) {
            int i=0, j=1;

            while(j < l) {
                if(nums[i] > nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
                i++;
                j++;
            }
            l--;
        }
    }
}
