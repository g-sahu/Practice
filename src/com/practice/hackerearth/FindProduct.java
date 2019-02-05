package com.practice.hackerearth;

import java.util.Scanner;

public class FindProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int size = sc.nextInt();
		long prod = 1;
		int mod = (int) Math.pow(10, 9) + 7;
		
		for(int i=0; i<size; i++) {
			prod = (prod * sc.nextInt()) % mod;
		}
		
		System.out.println(Math.abs(prod));
		sc.close();
	}
}
