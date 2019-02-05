package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DistinctStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String s;
		
		for(int i=0; i<t; i++) {
			s = sc.next();
			countDistinctStrings(s);
		}
		
		sc.close();
	}
	
	static void countDistinctStrings(String str) {
		int c = 0, max = 1;
		char arr[] = str.toCharArray();
		Set<Character> set = new HashSet<Character>();
		List<Character> vowels = new ArrayList<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		for(Character ch: arr) {
			if(ch == '_') {
				c = set.size();
				
				if(c != 0) {
					max = max * c;
				}
				
				set.clear();
			} else if(vowels.contains(ch)) {
				set.add(ch);
			}
		}
		
		System.out.println(max);
	}
}
