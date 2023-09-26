package com.interviews;

/**
 * Program to print sum of the both diagonal of matrix using only one loop.
 * @author gasahu
 *
 */
public class Matrix {
	private static final int[][] arr = {
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5}
							};

	public static void main(String[] args) {
		int start = 0;
		int end = arr[0].length - 1;
		int sum = 0;

        for (int[] nums : arr) {
            sum = sum + nums[start++] + nums[end--];
        }
		
		System.out.println(sum);
	}
	
}
