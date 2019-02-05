package com.contests.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class DigitsSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int t, k;
		int nums[] = new int[n];
		int output[] = new int[q];
		
		for(int i=0; i<n; i++) {
			nums[i] = (int) getSumOfDigits(sc.nextLong());
		}
		
		Arrays.sort(nums);
		
		for(int j=0; j<q; j++) {
			t = sc.nextInt();
			k = sc.nextInt();
			
			output[j] = getSetValue(nums, t, k);
		}
		
		sc.close();
		
		for(int i=0; i<q; i++) {
			System.out.println(output[i]);
		}
	}
	
	static long getSumOfDigits(long n) {
		long q = n, r, x = 0;
		
		if(n < 10) {
			return n;
		} else {
			while(q > 0) {
				r = q % 10;
				q = q / 10;
				x = x + r;
			}
			
			return getSumOfDigits(x);
		}
	}
	
	static int getSetValue(int nums[], int t, int k) {
		int l = nums.length;
		int sum = 0;
		int i, c;
		
		switch(t) {
			case 1:
				i = l-1;
				c = 0;
				
				while(c < k) {
					sum = sum + nums[i--];
					c++;
				}
				
				return sum;
				
			case 2:
				i = 0;
				
				while(i < k) {
					sum = sum + nums[i];
					i++;
				}
				
				return sum;
				
			default:
				return 0;
		}
	}

}
