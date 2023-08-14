package com.practice.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {15,7,3,8,6,1,23,14,18};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] nums) {
        int l = nums.length - 1;

        while (l >= 0) {
            for (int i = 0; i < l; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }

            l--;
        }
    }
}
