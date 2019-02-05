package com.contests.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PortfolioManager {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String tree = br.readLine();
		br.close();
		System.out.println(findMax(n, tree));
	}
	
	static long findMax(int n, String tree) {
		long even = 0, odd = 0;
		String arr[] = tree.split(" ");
		int k=0;
		int h = ((int) Math.sqrt(arr.length + 1)) - 1;

		for(int i=0; i<h; i++) {
			if(i % 2 == 0) {
				k = (int) Math.pow(2, i);

				for(int j=0; j<k; j++) {
					if(!arr[j].equals("#")) {
						even = even + Integer.parseInt(arr[j]);
					}
				}
			} else {
				k = (int) Math.pow(2, i);

				for(int j=0; j<k; j++) {
					if(!arr[j].equals("#")) {
						odd = odd + Integer.parseInt(arr[j]);
					}
				}
			}
		}

		return even > odd ? even : odd;
	}

}
