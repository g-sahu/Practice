package com.practice.sorting;

import java.util.Arrays;

/*
 * Merge Sort
 * Time Complexity - O(n * log n)
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 7, 3, 8, 6, 10, 23, 14, 18};
        int l = arr.length;

        System.out.println(Arrays.toString(arr));
        merge_sort(arr, 0, l-1);
        System.out.println(Arrays.toString(arr));
    }

    static void merge_sort(int arr[], int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;

            merge_sort(arr, start, mid);
            merge_sort(arr, mid+1, end);

            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {

    }

}
