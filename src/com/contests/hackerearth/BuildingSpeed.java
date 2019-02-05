package com.contests.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class BuildingSpeed {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[2*n];
		
		for(int i=0; i<2*n; i++) {
			a[i] = sc.nextInt();
		}
		
		sc.close();
		printMax(a);
	}
	
	static void printMax(int a[]) {
		int max = 0;
		int l = a.length;
		
		Arrays.sort(a);
		for(int i=0; i<l; i+=2) {
			max = max + a[i];
		}
		
		System.out.println(max);
	}

}
