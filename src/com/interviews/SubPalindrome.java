package com.interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Program to print the palindromic substrings in a given string.
 * @author gasahu
 *
 */
public class SubPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		printSubPalindromes(str);
	}
	
	private static void printSubPalindromes(String s) {
		char str[] = s.toCharArray();
		int l = str.length;
		int j = 0;
		
		for(int i=0; i<l; i++) {
			j = i + 1;
			
			while(j < l) {
				if(isPalindrome(str, i, j)) {
					System.out.println(s.substring(i, j+1));
				}
				
				j++;
			}
		}
		
	}
	
	private static boolean isPalindrome(char str[], int i, int j) {
		while(i < j) {
			if(str[i] != str[j]) {
				return false;
			}
			
			i++;
			j--;
		}
		
		return true;
	}
}
