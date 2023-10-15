package com.practice.dp;

import java.util.Scanner;

public class Greatest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		System.out.println(findGreatest(arr));
	}
	
	private static int findGreatest(int arr[]) {
		int max=arr[0];
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}		

		return max;
	}
	
	void show() {
		int x = 20;
		System.out.println(x);
	}
	
	static void show1() {
		//show();
	}

}
