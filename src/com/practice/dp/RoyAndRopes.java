package com.practice.dp;

import java.util.Scanner;

public class RoyAndRopes {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		int upper[], lower[];
		
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			upper = new int[n-1];
			lower = new int[n-1];
			
			for(int j=0; j<n-1; j++) {
				upper[j] = sc.nextInt(); 
			}
			
			for(int j=0; j<n-1; j++) {
				lower[j] = sc.nextInt(); 
			}
			
			System.out.println(findTimeToBurn(n, upper, lower));
		}
		
		sc.close();
	}
	
	private static int findTimeToBurn(int n, int upper[], int lower[]) {
		int count = 0;
		int memo[] = new int[n-1];		
		int x;
		
		for(int i=0; i<n-1; i++) {
			x = upper[i] > lower[i] ? upper[i] : lower[i];
			memo[i] = x - (n - (i + 1)); 
		}
		
		count = memo[0];
		
		for(int i=0; i<n-1; i++) {
			count = memo[i] > count ? memo[i] : count;
		}
		
		
		if(count > 0) {
			return count + n;
		} else {
			return n;
		}		
	}

}
