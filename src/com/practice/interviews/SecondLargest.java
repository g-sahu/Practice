package com.practice.interviews;

public class SecondLargest {

	public static void main(String[] args) {
		int arr[] = { 100, 46, 47, 86, 92, 52, 48, 36, 66, 87 };
		int largest = arr[0];
		int secondLargest = arr[0];
		
		System.out.println("The given array is:" );
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
 
			} else if (arr[i] > secondLargest) {
				secondLargest = arr[i];
			}
		}
 
		System.out.println("\nSecond largest number is: " + secondLargest);
	}

}
