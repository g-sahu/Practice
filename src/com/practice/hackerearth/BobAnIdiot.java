package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BobAnIdiot {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<String>();
		String str;
		
		for(int i=0; i<n; i++) {
			list.add(br.readLine());
		}
		
		str = br.readLine();
		br.close();
		printCode(str, list);
	}
	
	static void printCode(String str, List<String> list) {
		Iterator<String> itr = list.iterator();
		String s[];
		String ch = "?";
		
		while(itr.hasNext()) {
			s = itr.next().split(" ");
			str = str.replace(s[0], ch);
			str = str.replace(s[1], s[0]);
			str = str.replace(ch, s[1]);
		}
		
		System.out.println(str);
	}

}
