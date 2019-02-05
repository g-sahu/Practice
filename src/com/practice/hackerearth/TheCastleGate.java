package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TheCastleGate {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;

		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			list.add(getNumberOfPairs(n));
		}

		sc.close();
		Iterator<Integer> itr = list.iterator();

		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	private static int getNumberOfPairs(int n) {
		int res = 0, j;
		
		for(int i=1; i<n; i++) {
			j = i + 1;
			
			while(j <= n) {
				if((i ^ j) <= n) {
					res++;
				}
				
				j++;
			}
		}
		
		return res;
	}

}
