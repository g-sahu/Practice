package com.contests.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Special Substrings 
 * You have a string S but you like only special strings. So, you have to calculate the total number of special substrings in S
 * A string T of length L is called special string, if either of the following property holds:
 * 	1. All characters of the string T are same. for example, aaa
 * 	2. The string has an odd length (i.e, L is odd) and all characters of T are same except the middle character, for example, aabaa
 * 
 * Count the total number of special substrings in S
 * @author gasahu
 *
 */
public class SpecialSubstrings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char ch[] = str.toCharArray();
		int l = ch.length;
		int c = 0;
		
		for(int i=0; i<l; i++) {
			for(int j=i; j<l; j++) {
				if(ch[i] == ch[j]) {
					c++;
				} else {
					break;
				}
			}
		}
		
		for(int i=1; i<l-1; i++) {
			for(int j=1; j<=i; j++) {
				if((ch[i-j] == ch[i+j]) && 
						(ch[i-j] != ch[i]) && 
						(ch[i+j] != ch[i])) {
					c++;
				} else {
					break;
				}
			}
		}
		
		System.out.println(c);
	}

}
