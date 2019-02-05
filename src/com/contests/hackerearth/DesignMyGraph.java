package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DesignMyGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int n;
		ArrayList<Integer[]> outputList = new ArrayList<>();
		Integer arr[];
		
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			arr = new Integer[n];
			
			for(int j=0; j<n; j++) {
				arr[j] = sc.nextInt();
			}
			
			outputList.add(arr);
		}
		
		sc.close();
		Iterator<Integer[]> itr = outputList.iterator();
		
		while(itr.hasNext()) {
			isGraph(itr.next());
		}
	}
	
	static void isGraph(Integer arr[]) {
		int sum = 0;
		int n = arr.length;
		
		for(Integer i: arr) {
			if(i >= n) {
				System.out.println("NO");
				break;
			}
			
			sum = sum + i;
		}
		
		if(sum % 2 == 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}

}
