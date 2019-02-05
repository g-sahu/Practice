package com.contests.hackerearth;

import java.util.Scanner;

public class GameOfNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		solveFunction(arr);
	}
	
	static void solveFunction(int arr[]) {
		int l = arr.length;
		int f = -1;
		
		for(int i=0; i<l; i++) {
			f = findFx(i, arr);
			
			if(f == -1) {
				System.out.print(f + " ");
			} else {
				System.out.print(findGx(arr[f], arr, f) + " ");
			}
		}
	}
	
	static int findFx(int x, int arr[]) {
		int n = arr.length;
		
		for(int i=x+1; i<n; i++) {
			if(arr[i] > arr[x]) {
				return i;
			}
		}
		
		return -1;
	}
	
	static int findGx(int x, int arr[], int z) {
		int n = arr.length;

		for(int i=z+1; i<n; i++) {
			if(arr[i] < x) {
				return arr[i];
			}
		}

		return -1;
	}
}
