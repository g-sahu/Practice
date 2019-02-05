package com.contests.hackerearth;

import java.util.Scanner;

public class KilljeeAndClosestNum {
	static long arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new long[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int q = sc.nextInt();
		int t, u = 0, l = 0, r = 0;
		long p = 0;
		
		for(int i=0; i<q; i++) {
			t = sc.nextInt();
			
			if(t == 1) {
				u = sc.nextInt();
				p = sc.nextInt();
				update(u, p);
			} else {
				l = sc.nextInt();
				r = sc.nextInt();
				p = sc.nextInt();
				findK(l-1, r-1, p);
			}
		}
		
		sc.close();
	}
	
	static void update(int u, long p) {
		arr[u] = p;
	}
	
	static void findK(int l, int r, long p) {
		long k = -1;
		
		for(int i=l; i<r; i++) {
			if(arr[i] > p) {
				if(k == -1) {
					k = arr[i];
				} else {
					k = arr[i] < k ? arr[i] : k;
				}
			}
		}
		
		System.out.println(k);
	}
}
