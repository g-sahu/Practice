package com.interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RemoveCharacters {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		char ch1[] = s1.toCharArray();
		char ch2[] = s2.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		int c = 1, l = ch1.length;
		
		for(int i=0; i<l; i++) {
			if(map.containsKey(ch1[i])) {
				c = map.get(ch1[i]);
				map.put(ch1[i], ++c);
			} else {
				map.put(ch1[i], 1);
			}
		}
		
		for(int i=0; i<ch2.length; i++) {
			
		}
	}
}
