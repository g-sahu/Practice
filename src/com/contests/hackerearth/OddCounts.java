package com.contests.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddCounts {
	static String arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		arr = str.split("");
		int l = arr.length;
		int j = 0, d, c = 0;
		
		for(int i=0; i<l; i++) {
			j = i;
			
			while(j < l) {
				d = convertToDecimal(i, j);
				
				if(d % 2 != 0) {
					c++;
				}
				
				j++;
			}
		}
		
		System.out.println(c);
	}
	
	static int convertToDecimal(int l, int r) {
 		int d = 0, c = 0;
		
		for(int i=r; i>=l; i--) {
			if(!(c == 0 && arr[i].equals("0"))) {
				d = d + Integer.valueOf(arr[i]) * (int) Math.pow(2, c++);
			}
		}
		
		return d;
	}

}
