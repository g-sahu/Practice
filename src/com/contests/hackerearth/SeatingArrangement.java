package com.contests.hackerearth;

import java.util.Scanner;

public class SeatingArrangement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int arr[][] = new int[m][k];
		int count[] = new int[m];
		int c, x, num = 0;
		
		for(int i=0; i<n; i++) {
			x = sc.nextInt();
			c = count[x-1];
			
			if(c < k) {
				arr[x-1][c] = x;
				count[x-1] = c + 1;
			} else {
				c = count[x];
				
				if(c < k) {
					arr[x][c] = x;
					count[x] = c + 1;
				}
				
				num++;
			}
		}
		
		sc.close();
		System.out.println(num);
	}

}
