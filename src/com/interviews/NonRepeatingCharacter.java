package com.interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Print nth non-repeating character in a string
 * @author gasahu
 *
 */
public class NonRepeatingCharacter {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(br.readLine());
		System.out.println(getNonRepeatingChar(str, n));
	}
	
	static char getNonRepeatingChar(String str, int n) {
		char ch;
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for(int i=0; i<str.length(); i++) {
			ch = str.charAt(i);
			
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		
		Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
		int i = 1;
		
		for(Map.Entry<Character, Integer> entry : entrySet) {
			if(entry.getValue() == 1 && i++ == n) {
				return entry.getKey();
			}
		}
		
		return '\u0000';
	}

}
