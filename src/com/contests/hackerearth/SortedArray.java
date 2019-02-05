package com.contests.hackerearth;

import java.util.Scanner;

public class SortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int j = 0, diff, m = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<n-1; i++) {
			j = i+1;
		
			if(arr[i] >= arr[j]) {
				diff = arr[i] - arr[j];
				arr[j] = arr[j] + diff + 1;
				m = m + diff + 1;
			}
		}
		
		System.out.println(m);
		sc.close();
	}

}
