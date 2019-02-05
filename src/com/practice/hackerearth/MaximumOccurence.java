package com.practice.hackerearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MaximumOccurence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char s[] = sc.nextLine().toCharArray();
		sc.close();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int c = 1, max = 1;
		
		for(int i=0; i<s.length; i++) {
			if(map.containsKey(s[i])) {
				c = map.get(s[i]);
				map.put(s[i], ++c);
				max = c > max ? c : max;
			} else {
				map.put(s[i], 1);
			}
		}
		
		Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
		Character maxChar = null;
		Character ch;
		
		for(Map.Entry<Character, Integer> entry : entrySet) {
			if(entry.getValue() == max) {
				ch = entry.getKey();
				
				if(maxChar == null) {
					maxChar = ch;
				} else {
					maxChar = ch < maxChar ? ch : maxChar;
				}
			}
		}
		
		System.out.println(maxChar + " " + max);
	}

}
