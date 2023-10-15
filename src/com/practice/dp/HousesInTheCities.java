package com.practice.dp;

import java.util.Scanner;

public class HousesInTheCities {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		int[] arr;
		int q, l, r;
		
		
		for(int j=0; j<t; j++) {
			n = sc.nextInt();
			arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}

			q = sc.nextInt();

			for(int i=0; i<q; i++) {
				l = sc.nextInt();
				r = sc.nextInt();
				System.out.println(calculateHouses(arr, l, r));
			}
		}
		
		sc.close();
	}
	
	private static int calculateHouses(int arr[], int l, int r) {
		int sum = 0;
		
		for(int i=l-1; i<=r-1; i++) {
			sum = sum + arr[i];
		}
		
		return sum;
	}

}
