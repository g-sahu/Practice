package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DivisorQueries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		//No. of integers
		int m = sc.nextInt();		//No. of queries
		int arr[] = new int [n];	
		Integer q[];
		ArrayList<Integer[]> queryList = new ArrayList<>();
		int k, l = 0, r = 0, prod, divs, res;
		int mod = (int) Math.pow(10, 9) + 7;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int j=0; j<m; j++) {
			q = new Integer[2];
			q[0] = sc.nextInt();
			q[1] = sc.nextInt();
			queryList.add(q);
		}
		
		sc.close();
		Iterator<Integer[]> itr = queryList.iterator();
		
		while(itr.hasNext()) {
			q = itr.next();
			k = 0;
			
			while(k < arr.length) {
				if(arr[k] == q[0]) {
					l = k;
				} else if(arr[k] == q[1]) {
					r = k;
				}
				
				k++;
			}
			
			prod = findProduct(arr, l, r);
			divs = findDivisors(prod);
			res = divs % mod;
			System.out.println(res);
		}
	}
	
	static int findProduct(int arr[], int i, int j) {
		int prod = 1;
		
		for(; i<=j; i++) {
			prod = prod * arr[i];
		}
		
		return prod;
	}
	
	static int findDivisors(int n) {
		int c = 0;
		
		for(int i=1; i<=n; i++) {
			if((n % i) == 0) {
				c++;
			}
		}
		
		return c;
	}
}
