package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String s = br.readLine();
			System.out.println(isPalindrome(s) ? "YES" : "NO");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean isPalindrome(String s) {
		char ar[] = s.toCharArray();
		int i = ar.length - 1;
		
		for(Character c: ar) {
			if(c != s.charAt(i--)) {
				return false;
			}
		}
		
		return true;
	}
}
