package com.contests.hackerearth;

import java.util.Scanner;

public class StampedRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		long m, n, k;

		for(int i=0; i<t; i++) {
			m = sc.nextLong();
			n = sc.nextLong();
			k = sc.nextLong();

			System.out.println(printArea(m, n, k));
		}

		sc.close();
	}

	static long printArea(long m, long n, long k) {
		long area = 0, i = 2, q = 1;

		if(k <= m || k <= n) {
			area = k;
		} else {
			if(k >= (m*n)) {
				area = m*n;
			} else {
				q = k/i;

				while(((i < m) || (i < n)) && (q > m || q > n)) {
					i++;
					q = k/i;
				}
				
				area = q * i;
			}

		}

		return area;
	}

}
