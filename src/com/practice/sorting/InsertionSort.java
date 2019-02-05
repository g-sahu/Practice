package com.practice.sorting;

import java.util.Arrays;

/*
 * Insertion sort 
 * Time complexity - O(n^2)
 */

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {5, 7, 3, 8, 6, 10, 23, 14, 18};
		int l = arr.length;
		int j, t;
		
		for(int i=0; i<l-1; i++) {
			j = i+1;
			
			while(j > 0 && (arr[j] < arr[j-1])) {
				t = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = t;
				j--;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
