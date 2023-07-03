package com.interviews;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		int arr[][] = { {1, 2, 3, 4},
						{5, 6, 7, 8},
						{9, 10, 11, 12},
						{13, 14, 15, 16}
					};
		
		int rows = arr.length;
		int cols = arr[0].length;
		int i = 0, j = cols-1;
		int ar[] = null;
		int x = 10;
		
		while(i <= rows) {
			if(arr[i][j] < x) {
				i++;
			} else {
				ar = arr[i];
				break;
			}
			
			i++;
		}	
		
		if(ar != null) {
			System.out.println(Arrays.binarySearch(ar, x));
		} else {
			System.out.println("Number not found");
		}
	}
}
