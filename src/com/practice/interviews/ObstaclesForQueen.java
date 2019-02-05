package com.practice.interviews;

import java.util.Scanner;

public class ObstaclesForQueen {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		int n, r, c;
		
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			System.out.println(calculateObstacles(n, r, c));
		}
		
		sc.close();
	}
	
	private static int calculateObstacles(int n, int r, int c) {
		int x1 = (int) Math.sqrt((r * r) + (c * c));
		int x2 = (int) Math.sqrt(((n-r) * (n-r)) + ((n-c) * (n-c)));
		int y1 = (int) Math.sqrt(((n-r) * (n-r)) + ((n-c) * (n-c)));
		int y2 = (int) Math.sqrt(((n-r) * (n-r)) + ((n-c) * (n-c)));
		
		int moves = n + (n -1) + x1 + x2 + y1 + y2 - 3;
		return (n * n) - moves;
	}

}
