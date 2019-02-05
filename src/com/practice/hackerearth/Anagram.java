package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Anagram {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<String>();
		List<String> outList = new ArrayList<String>();
		String s = br.readLine();
		
		while(!s.isEmpty()) {
			list.add(s);
			s = br.readLine();
		}
		
		String listArr[] = new String[list.size()];
		Iterator<String> itr = list.iterator();
		int i = 0, k = 0;
		
		while(itr.hasNext()) {
			listArr[i++] = itr.next(); 
		}
		
		for(int j=0; j<listArr.length-1; j++) {
			k = j + 1;
			
			String s1 = listArr[j];
			String s2 = listArr[k];
			
			if(isAnagram(s1, s2)) {
				if(s1.charAt(0) < s2.charAt(0)) {
					outList.add(s1 + "," + s2);
				} else {
					outList.add(s2 + "," + s1);
				}
			}
			
		}
		
		itr = outList.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()); 
		}
	}
	
	static boolean isAnagram(String s1, String s2) {
		boolean result = false;
		
		if(s1.length() == s2.length()) {
			int start = 0;
			int end = s1.length() - 1;
			
			while(s1.charAt(start) == s2.charAt(end)) {
				start++;
				end--;
			}
		}
		
		return result;
	}

}
