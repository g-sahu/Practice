package com.practice.dp;

import java.util.Scanner;

public class XSquareCoinCollection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		long k;
		long[] arr;

		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			k = sc.nextLong();
			arr = new long[n];

			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextLong();
			}

			System.out.println(findMaxCoins(arr, n, k));
		}

		sc.close();
	}
	
	private static long findMaxCoins(long[] arr, int n, long k) {
		long max = 0;
		long[] memo = new long[n];

		for (int i = 0; i < n; i++) {
			if (arr[i] <= k) {
				if (i == 0) {
					memo[i] = arr[i];
				} else {
					memo[i] = arr[i] + memo[i - 1];
				}
			}

			max = Math.max(memo[i], max);
		}

		return max;
	}

}
