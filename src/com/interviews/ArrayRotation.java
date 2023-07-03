package com.interviews;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int d = sc.nextInt();
		sc.close();
		rotateArray(a, d);
	}
	
	static void rotateArray(int a[], int d) {
		int l = a.length;
		int arr[] = new int[l];
		int x = l-d, y = 0;
		
		for(int i=0; i<l; i++) {
			if(i < d) {
				arr[x++] = a[i];
			} else {
				arr[y++] = a[i];
			}
		}
		
		System.out.println(Arrays.toString(arr));		
	}
}
