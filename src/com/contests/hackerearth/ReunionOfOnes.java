package com.contests.hackerearth;

import java.util.Scanner;

public class ReunionOfOnes {
	private static final String ZERO = "0";
	private static final String ONE = "1";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String a[] = sc.next().split("");
		int q = 0, x;
		
		for(int i=0; i<k; i++) {
			q = sc.nextInt();
			
			if(q == 1) {
				printMaxSubarray(a);
			} else {
				x = sc.nextInt();
				
				if(a[x-1].equals(ZERO)) {
					a[x-1] = ONE;
				}
			}
		}
		
		sc.close();
	}
	
	static void printMaxSubarray(String a[]) {
		int max = 0, c = 0;
		int l = a.length;
		
		for(int i=0; i<l; i++) {
			if(a[i].equals(ONE)) {
				c++;
			} else {
				max = c > max ? c : max;
				c = 0;
			}
		}
		
		max = c > max ? c : max;
		System.out.println(max);
	}
}
