package com.interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] words = str.split(" ");
		Arrays.sort(words);  
		StringBuilder sb = new StringBuilder();
		
		for(String s: words){  
		   sb.append(s);
		   sb.append(" ");  
		}  

		String sorted = sb.toString().trim(); 
		System.out.println(sorted);
	}
}
