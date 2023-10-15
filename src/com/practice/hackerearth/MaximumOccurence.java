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

		Map<Character, Integer> map = new HashMap<>();
		int c, max = 1;

		for (char value : s) {
			if (map.containsKey(value)) {
				c = map.get(value);
				map.put(value, ++c);
				max = Math.max(c, max);
			} else {
				map.put(value, 1);
			}
		}

		Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
		Character maxChar = null;
		Character ch;

		for (Map.Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() == max) {
				ch = entry.getKey();

				if (maxChar == null) {
					maxChar = ch;
				} else {
					maxChar = ch < maxChar ? ch : maxChar;
				}
			}
		}

		System.out.println(maxChar + " " + max);
	}

}
