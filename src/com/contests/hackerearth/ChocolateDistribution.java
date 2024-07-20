package com.contests.hackerearth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.max;

public class ChocolateDistribution {
	private static Map<String, Long> memo = new HashMap<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, m;
		int[] arr;
		
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			arr = new int[n];
			
			for(int j=0; j<n; j++) {
				arr[j] = sc.nextInt();
			}
			
			System.out.println(maxChocolates(arr, m));
		}
		
		sc.close();
	}
	
	private static long maxChocolates(int[] arr, int m) {
		int n = arr.length;
		long max = 0;

        for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
                String key = i + "," + j;

                if(!memo.containsKey(key)) {
					if(i == j) {
						memo.put(key, (long) arr[j]);
					} else {
						memo.put(key, memo.get(i + "," + (j-1)) + (long) arr[j]);
					}
				}

				if(memo.get(key) != 0 && memo.get(key) % m == 0) {
					max = max(memo.get(key) / m, max);
				}
			}
		}
		
		return max;
	}

}
