package com.contests.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LexicalAnalyser {
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			String s;

			for(int i=0; i<n; i++) {
				s = br.readLine();
				getVariables(s);
			}
			
			System.out.println(list.size());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void getVariables(String s) {
		int l = s.length();
		String var;
		int lastIndex = 0;
		
		for(int i=0; i<l; i++) {
			if(s.charAt(i) == '=') {
				var = s.substring(lastIndex, i);
				
				if(!list.contains(var)) {
					list.add(var);
					lastIndex = i+2;
				}
			}
		}
	}

}
