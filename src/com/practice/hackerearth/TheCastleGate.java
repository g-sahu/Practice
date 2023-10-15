package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

public class TheCastleGate {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;

		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			list.add(getNumberOfPairs(n));
		}

		sc.close();

        for (Integer integer : list) {
            System.out.println(integer);
        }
	}
	
	private static int getNumberOfPairs(int n) {
		int res = 0, j;

		for (int i = 1; i < n; i++) {
			j = i + 1;

			while (j <= n) {
				if ((i ^ j) <= n) {
					res++;
				}

				j++;
			}
		}

		return res;
	}

}
