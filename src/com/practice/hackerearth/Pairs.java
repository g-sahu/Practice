package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pairs {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		String split[];
		
		try {
			n = Integer.parseInt(br.readLine());
			
			if(n >= 1 && n <= (int) Math.pow(10, 5)) {
				split = br.readLine().split(" ");
				
				if(split.length == n) {
					printUniquePairs(split);
				}
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printUniquePairs(String input[]) {
		int size = input.length;
		int j, c = 0;;
		
		Arrays.sort(input);
		
		for(int i=size-1; i>0; i--) {
			j = i-1;
			
			if(!input[i].equals(input[j])) {
				c++;
			}
		}
		
		System.out.println(c);
	}

}
