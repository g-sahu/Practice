package com.practice.interviews;

import java.util.Scanner;

public class CompatibilityDifference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr1[i] = sc.nextInt();
		}
				
		for(int i=0; i<n; i++) {
			arr2[i] = sc.nextInt();
		}
		
		sc.close();
		System.out.println(findCompatibilityDiff(arr1, arr2));
	}
	
	static int findCompatibilityDiff(int arr1[], int arr2[]) {
		int diff = 0;
		
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				for(int j=i; j<arr2.length; j++) {
					if(arr2[j] != arr1[i]) {
						diff++;
					}
				}
			}
		}
		
		return diff;
	}

}
