package com.practice.searching;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = {2, 5, 7, 9, 12, 15, 26, 47, 68};
		int key = 12;
		
		System.out.println("Array is: " + Arrays.toString(arr));
		System.out.println("Key is: " + key);
		System.out.println("Index is: " + binarySearch(arr, key));
	}
	
	private static int binarySearch(int arr[], int key) {
		int beg = 0;
		int end = arr.length - 1;
		
		while(beg != end) {
			int mid = (beg + end) / 2;

			if(key < arr[mid]) {
				end = mid - 1;
			} else if(key > arr[mid]) {
				beg = mid + 1;
			} else {
				return mid;
			}
		}
		
		return (key == arr[beg]) ? beg : -1;
	}
}
