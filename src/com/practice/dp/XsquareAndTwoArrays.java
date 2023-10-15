package com.practice.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XsquareAndTwoArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int t, l, r;
		Map<String, Long> map1 = new HashMap<>();
		Map<String, Long> map2 = new HashMap<>();
		String key;
		long sum;
		boolean flag;

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}

		for (int i = 0; i < q; i++) {
			t = sc.nextInt();
			l = sc.nextInt();
			r = sc.nextInt();
			key = l + "," + r;
			sum = 0;
			flag = false;

			switch (t) {
				case 1:
					if (map1.containsKey(key)) {
						System.out.println(map1.get(key));
					} else {
						for (int j = l - 1; j <= r - 1; j++) {
							if (!flag) {
								sum = sum + a[j];
								flag = true;
							} else {
								sum = sum + b[j];
								flag = false;
							}
						}

						map1.put(key, sum);
						System.out.println(sum);
					}

					break;

				case 2:
					if (map2.containsKey(key)) {
						System.out.println(map2.get(key));
					} else {
						for (int j = l - 1; j <= r - 1; j++) {
							if (!flag) {
								sum = sum + b[j];
								flag = true;
							} else {
								sum = sum + a[j];
								flag = false;
							}
						}

						map2.put(key, sum);
						System.out.println(sum);
					}

					break;
			}
		}

		sc.close();
	}

}
