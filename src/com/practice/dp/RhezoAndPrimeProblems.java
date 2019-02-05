package com.practice.dp;

import java.util.Scanner;

public class RhezoAndPrimeProblems {

    public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		System.out.println(findMaximumPoints(arr));
	}
	
	private static int findMaximumPoints(int arr[]) {
		int n = arr.length;
		int memo[] = new int[n];
		int x = findMaxPrime(n);
		int c, max;
		
		if(x == -1) {
			return 0;
		}
		
		for(int i=x-1; i<n; i++) {
			c = 0;
			
			for(int j=0; j<x; j++) {
				c = c + arr[j];
			}
			
			memo[i] = c;
		}
		
		max = memo[0];
		
		for(int i=0; i<n; i++) {
			max = max < memo[i] ? memo[i] : max;
		}
		
		return max;
	}
	
	private static int findMaxPrime(int n) {
		if(n < 2) {
			return -1;
		} else {
			for(int i=n; i>1; i--) {
				if(isPrime(i)) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	private static boolean isPrime(int n) {
		if (n == 1) { 
			return false;
		}
		
	    if (n <= 3) {
	    	return true;
	    }
	 
	    if (n%2 == 0 || n%3 == 0) {
	    	return false;
	    }
	 
	    for (int i=5; i*i<=n; i=i+6) {
	        if (n%i == 0 || n%(i+2) == 0) {
	           return false;
	        }
	    }
	 
	    return true;
	}


}
