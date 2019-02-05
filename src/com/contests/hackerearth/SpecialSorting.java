package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SpecialSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		specialSort(arr);
	}
	
	static void specialSort(int arr[]) {
		List<Integer> prime = new ArrayList<Integer>();
		List<Integer> nonPrime = new ArrayList<Integer>();
		
		for(Integer i: arr) {
			if(isPrime(i)) {
				prime.add(i);
			} else {
				nonPrime.add(i);
			}
		}
		
		Collections.sort(prime);
		Collections.sort(nonPrime, Collections.reverseOrder());
		prime.addAll(nonPrime);
		
		Iterator<Integer> itr = prime.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}
	
	static boolean isPrime(int n) {
		if (n == 1) { 
			return false;
		}
		
	    if (n <= 3) {
	    	return true;
	    }
	 
	    if (n%2 == 0 || n%3 == 0) {
	    	return false;
	    }
	 
	    for (int i=5; i*i<=n; i=i+6)
	        if (n%i == 0 || n%(i+2) == 0)
	           return false;
	 
	    return true;
	}

}
