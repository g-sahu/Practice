package com.contests.hackerearth;

import java.util.HashMap;
import java.util.Scanner;

public class InAnArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		System.out.println(getUnorderedPairs(arr, n, k, x, y));
	}
	
	static int getUnorderedPairs(int arr[], int n, int k, int x, int y) {
		int c = 0;
		int a, b;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				a = (arr[i] + arr[j]) % k;
				b = (arr[i] * arr[j]) % k;
				
				if((a == x) && (b == y)) { 
					if(map.containsKey(i) && map.containsKey(j) && j != map.get(i) && i != map.get(j)) {
						map.put(i, j);
						c++;
					} else {
						map.put(i, j);
						c++;
					}
				}
			}
			
		}
		
		return c;
	}

}
