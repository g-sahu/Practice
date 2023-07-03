package com.interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRotationDetection {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		br.close();
		
		detectRotationConcat(str1, str2);
	}
	
	/**
	 * Detect if str2 is rotation of str1 using concatenation
	 * @param str1
	 * @param str2
	 */
	static void detectRotationConcat(String str1, String str2) {
		String temp = str1 + str1;
		
		if(temp.contains(str2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
