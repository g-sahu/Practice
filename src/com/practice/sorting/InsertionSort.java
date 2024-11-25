package com.practice.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Insertion sort 
 * Time complexity - O(n^2)
 */
public class InsertionSort {

	public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\Gaurav\\Desktop\\Array.txt"));
        int[] arr = new int[100000];
        int x = 0;

        while (sc.hasNext()) {
            arr[x++] = sc.nextInt();
        }

		int l = arr.length;
		int j, t;
		long start = System.currentTimeMillis();
		
		for(int i=0; i<l-1; i++) {
			j = i+1;
			
			while(j > 0 && (arr[j] < arr[j-1])) {
				t = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = t;
				j--;
			}
		}

		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time taken: " + (end - start));
	}
}
