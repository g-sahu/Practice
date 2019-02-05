package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Swaps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		ArrayList<Integer> outList = new ArrayList<>();
		Integer arr[];
		int n, k, p;
		int mod = (int) Math.pow(10, 9) + 7;
		
		for(int i=0; i<t; i++) {
			arr = new Integer[2];
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			
			n = arr[0];
			k = arr[1];
			
			p = getPermutations(n, k);
			outList.add(p * k * 2);
		}
		
		sc.close();
		Iterator<Integer> itr = outList.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next() % mod);
		}
	}
	
	static int getPermutations(int n, int k) {
		int p = n;
		
		for(int i=n-1; i > (n-k+1); i--) {
			p = p * i;
		}
		
		return p;
	}

}
