package com.practice.hackerearth;

import java.util.Scanner;

public class MillyAndSpecialSubarrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		long[] arr;
		
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			arr = new long[n];
			
			for(int j=0; j<n; j++) {
				arr[j] = sc.nextLong();
			}
			
			System.out.println(calculateSpecialSubarrays(arr));
		}
		
		sc.close();
	}
	
	private static int calculateSpecialSubarrays(long[] arr) {
		int n = arr.length;
		int[] memo = new int[n];
		int c = 0;
		
		for(int i=0; i<n; i++) {
			if((i != 0) && (arr[i] == arr[i-1])) {
				memo[i] = memo[i-1] + 1;
            } else {
				memo[i] = 1;
            }
            c = c + memo[i];
        }
		
		return c;
	}

}
