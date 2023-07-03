package com.interviews;

import java.util.Scanner;

public class MinimumDistance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long d1 = sc.nextLong();
		long d2 = sc.nextLong();
		long d3 = sc.nextLong();
		sc.close();
		
		long r1 = d1 + d2 + d3;
		long r2 = (2 * d1) + (2 * d2);
		
		if(d1 == 0) {
			System.out.println(d2);
		} else if(d2 == 0) {
			System.out.println(d1);
		} else if(d3 == 0) {
			System.out.println(d1);
		} else if(d3 == d2 - d1) { 
			System.out.println(d2);
		} else if(d3 == d1 - d2) { 
			System.out.println(d1);
		} else if(r1 < r2) {
			System.out.println(r1);
		} else {
			System.out.println(r2);
		}
	}
}
