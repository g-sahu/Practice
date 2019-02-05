package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CrossTheRiver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int n = 0;
		long a = 0, b = 0;
		ArrayList<Long[]> list = new ArrayList<Long[]>();
		Long arr[];
		
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			
			for(int j=0; j<n; j++) {
				arr = new Long[3];
				arr[0] = sc.nextLong();
				arr[1] = sc.nextLong();
				arr[2] = sc.nextLong();
				
				list.add(arr);
			}
			
			a = sc.nextLong();
			b = sc.nextLong();
			
			System.out.println(getMinRocks(n, list, a, b));
		}
		
		sc.close();
		

	}
	
	static int getMinRocks(int n, ArrayList<Long[]> list, long a, long b) {
		int count = -1;
		long x, y, r, d, c, w;
		
		Iterator<Long[]> itr = list.iterator();
		
		
		
		w = a - b;
		
		return count;
	}

}
