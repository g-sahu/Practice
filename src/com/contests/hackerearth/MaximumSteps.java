package com.contests.hackerearth;

import java.util.Scanner;

/**
 * You have an array A of length N. 
 * You can perform an operation multiple times on the elements of the array A. 
 * In the operation you can divide any element by its smallest factor greater than 1. 
 * You will be given Q tasks. 
 * In each task, you will be given an integer K and you have to tell the maximum number of elements in array A 
 * that can be reduced to 1 by using the operation at most K times.
 * 
 * Input:
 * First line contains two space separated integers, N and Q.
 * Second line contains N space separated integers denoting the elements of the array A.
 * Next Q lines contains an integer each, denoting the value of K
 * 
 * Output:
 * For each task, print the answer of the ith
 * task in a new line.
 * @author gasahu
 *
 */
public class MaximumSteps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<q; i++) {
			System.out.println(divideArray(arr, sc.nextInt()));
		}
		
		sc.close();
	}
	
	static int divideArray(int arr[], int q) {
		int count = 0;
		int lcd = 1;
		int x = 1;
		int n;
		
		for(int i=0; i<arr.length; i++) {
			lcd = getSmallestFactor(arr[i]);
			x = 1;
			n = arr[i];
			
			while(x++ <= q) {
				if(n != 1) {
					n = n / lcd;
				} else {
					count++;
					break;
				}
			}
		}
		
		return count;
	}
	
	static int getSmallestFactor(int n) {
		int i = 2;
		
		while(i <= n/2) {
			if((n % i) == 0) {
				break;
			}
			
			i++;
		}
		
		return (i == n/2) ? n : i;
	}
}
