package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.reverseOrder;

public class BestSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int n;
		long[] arr;
		
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			arr = new long[n];
			
			for(int j=0; j<n; j++) {
				arr[j] = sc.nextLong();
			}
			
			printSubsequence(arr);
			System.out.println();
		}
		
		sc.close();
	}
	
	static void printSubsequence(long[] arr) {
		List<Long> negatives = new ArrayList<>();
		int l = arr.length;
		long sum = 0;

        for (long value : arr) {
            if (value > 0) {
                sum = sum + value;
            } else {
                negatives.add(value);
            }
        }
		
		if(sum % 2 != 0) {
			System.out.println(sum);
		} else {
			negatives.sort(reverseOrder());
			
			Iterator<Long> itr = negatives.iterator();
			long n;
			
			while(itr.hasNext()) {
				n = itr.next();
				
				if((sum + n) % 2 != 0) {
					System.out.println(sum + n);
				}
			}
		}
	}

}
