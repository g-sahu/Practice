package com.practice.hackerearth;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DistinctCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, x, size;
		Set<Integer> set;

		for (int i = 1; i <= t; i++) {
			n = sc.nextInt();
			x = sc.nextInt();
			set = new HashSet<>();

			for (int j = 1; j <= n; j++) {
				set.add(sc.nextInt());
			}

			size = set.size();

			if (size == x) {
				System.out.println("Good");
			} else if (size < x) {
				System.out.println("Bad");
			} else {
				System.out.println("Average");
			}
		}

		sc.close();
	}
}
