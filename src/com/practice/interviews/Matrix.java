package com.practice.interviews;

/**
 * Program to print sum of the both diagonal of matrix using only one loop.
 * @author gasahu
 *
 */
public class Matrix {
	private static int arr[][] = {
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5}
							};

	public static void main(String args[]) {
		int start = 0;
		int end = arr[0].length - 1;
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i][start++] + arr[i][end--];
		}
		
		System.out.println(sum);
	}
	
}
