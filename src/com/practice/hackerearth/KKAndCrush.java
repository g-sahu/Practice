package com.practice.hackerearth;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KKAndCrush {
	private static final String YES = "Yes";
	private static final String NO = "No";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		int n = 0, k = 0;
		
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			
			for(int j=0; j<n; j++) {
				set.add(sc.nextInt());
			}
			
			k = sc.nextInt();
			
			for(int x=0; x<k; x++) {
				if(set.contains(sc.nextInt())) {
					System.out.println(YES);
				} else {
					System.out.println(NO);
				}
			}
			
			set.clear();
		}
		
		sc.close();
	}
}
