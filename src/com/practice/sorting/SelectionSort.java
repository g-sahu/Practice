package com.practice.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {15,7,3,8,6,1,23,14,18};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;

			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			if (i != minIndex) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
}
