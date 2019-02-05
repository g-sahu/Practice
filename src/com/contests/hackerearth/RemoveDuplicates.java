package com.contests.hackerearth;

import java.util.ArrayList;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "AACCABB";
		char arr[] = str.toCharArray();
		int t = 0;
		ArrayList<Character> completedList = new ArrayList<Character>();
		
		for(Character c: arr) {			
			if(!completedList.contains(c)) {
				System.out.print(c);
				completedList.add(c);
			} else {
				t++;
			}
		}
		
		System.out.println();
		System.out.println("Operations: " + t);
	}
}
