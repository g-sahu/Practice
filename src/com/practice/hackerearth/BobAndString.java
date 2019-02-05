package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BobAndString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s, t;
		
		for(int i=0; i<n; i++) {
			s = sc.next();
			t = sc.next();
			convertString(s, t);
		}
		
		sc.close();
	}
	
	static void convertString(String s, String t) {
		List<String> sList = new ArrayList<String>(Arrays.asList(s.split("")));
		List<String> tList = new ArrayList<String>(Arrays.asList(t.split("")));
		int ls = sList.size();
		int lt = tList.size();
		int ops = 0;
		String str;
		
		Iterator<String> sItr = sList.iterator();
		while(sItr.hasNext()) {
			str = sItr.next();
			
			if(tList.contains(str)) {
				tList.remove(str);
			}
		}
		
		if(ls == lt) {
			ops = tList.size() * 2;
		} else if(ls > lt) {
			ops = (tList.size() * 2) + (ls - lt);
		} else {
			ops = (tList.size() * 2) - (lt - ls);
		}
		
		System.out.println(ops);
	}
}