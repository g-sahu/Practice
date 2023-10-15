package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

public class LifeAnswer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> output = new ArrayList<>();
		int n;

		while (sc.hasNext()) {
			n = sc.nextInt();

			if (n == 42) {
				break;
			}

			output.add(n);
		}

		sc.close();

		for (Integer integer : output) {
			System.out.println(integer);
		}
	}
}
