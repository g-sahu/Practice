package com.practice.dp;

import java.util.Scanner;

public class Subsequences {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		sc.close();
		
		printSubsequences(arr, k);
	}

	static void printSubsequences(int arr[], int k) {
		int l = arr.length;
		
		/*for(int x=0; x<l; x++) {
			for(int j=0; j<l; j++) {
				if(j != x) {
					if(j != arr.length) {
						System.out.print(arr[j] + " ");
					} else {
						System.out.print(arr[j]);
					}
				}
			}
			
			System.out.println();
		}*/
		
		int x = l - k;
		
		for(int i=0; i<k; i++) {
			for(int j=i+1; j<l; j++) {
				
			}
		}
	}
	
}