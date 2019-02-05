package com.contests.hackerearth;

import java.util.Scanner;

/**
 * Increasing Subsequence
 * 
 * Given an array, A, having N integers, an increasing subsequence of this array of length k is a set of k indices 
 * i1, i2, ... ik, such that 1 <= i1 <i2 < ... ik <= N and A[i1] < A[i2] < A[i3] < ... < A[ik]. 
 * Energy of a subsequence is defined as sum of difference of consecutive numbers in the subsequence. 
 * For a given integer k, you need to find out the maximum value of energy among energies of all increasing subsequences of length k.
 * 
 * Hint: Among all increasing sequences of length k ending at an index, find the sequence with minimum value of starting point
 * 
 * Input:
 * First line consists of two space separated integer denoting N and k. 
 * Second line consists of N space separated integers denoting the array A.
 * 
 * Output:
 * Print the maximum value of energy among energies of all increasing subsequences of length k.
 * If there are no increasing subsequences of length k in the array, print "-1" (without quotes")
 * @author gasahu
 *
 */
public class IncreasingSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		System.out.println(calculateMaxEnergy(arr, k));
	}
	
	static int calculateMaxEnergy(int arr[], int k) {
		int max = -1;
		
		
		
		return max;
	}

}
