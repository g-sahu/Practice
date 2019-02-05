package com.contests.hackerearth;

import java.util.Scanner;

public class SwapArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int q, l, r;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		q = sc.nextInt();
		
		for(int i=0; i<q; i++) {
			l = sc.nextInt();
			r = sc.nextInt();
			swap(arr, n, l, r);
		}
		
		sc.close();
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static void swap(int arr[], int n, int l, int r) {
		int temp, a, b;
		
		for(int i=l-1; i<=r-1; i++) {
			/*temp = arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = temp;*/
			a = arr[i];
			b = arr[n-i-1];
			
			if(a != b) {
				a = a + b;
				b = a - b;
				a = a - b;
				
				arr[i] = a;
				arr[n-i-1] = b;
			}
		}
	}

}
