package com.practice.hackerearth;

public class Operators {

	public static void main(String[] args) {
		int x = 10, y = 1;

		System.out.println("x & y: " + (x & y));
		System.out.println("x | y: " + (x | y));
		System.out.println("x ^ y: " + (x ^ y));
		System.out.println("x >> y: " + (x >> y));
		System.out.println("x >>> y: " + (x >>> y));
		System.out.println("x << y: " + (x << y));
		System.out.println("x < y: " + (x < y));
		System.out.println("x > y: " + (x > y));

		System.out.println(Integer.MAX_VALUE / (x >>> y));

	}

}
