package com.interviews;

import java.util.Scanner;

public class OverlappingRectangles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int x1, x2, x3, x4, y1, y2, y3, y4;
		
		for(int i=0; i<t; i++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			x3 = sc.nextInt();
			y3 = sc.nextInt();
			x4 = sc.nextInt();
			y4 = sc.nextInt();
			
			isOverlapping(x1, y1, x2, y2, x3, y3, x4, y4);
		}
		
		sc.close();
	}
	
	static void isOverlapping(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		if(x1 < x3 && x2 < x3) {
			System.out.println(0);
		} else if(y1 < y3 && y2 < y3) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}
}
