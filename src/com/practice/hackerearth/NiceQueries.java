package com.practice.hackerearth;

import java.util.Scanner;

public class NiceQueries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int arr[] = new int[n];
		int type, k, y;
		boolean exists;
		
		for(int i=0; i<q; i++) {
			type = sc.nextInt();
			exists = false;
			
			if(type == 1) {
				k = sc.nextInt() - 1;
				arr[k] = 1;
			} else {
				y = sc.nextInt() - 1;
				
				for(int j=y; j<n; j++) {
					if(arr[j] == 1) {
						System.out.println(j + 1);
						exists = true;
						break;
					}
				}
				
				if(!exists) {
					System.out.println(-1);
				}
			}
		}
		
		sc.close();
	}

}
