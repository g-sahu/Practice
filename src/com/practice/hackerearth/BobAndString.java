package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BobAndString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s, t;

		for (int i = 0; i < n; i++) {
			s = sc.next();
			t = sc.next();
			convertString(s, t);
		}

		sc.close();
	}
	
	static void convertString(String s, String t) {
		List<String> sList = new ArrayList<>(Arrays.asList(s.split("")));
		List<String> tList = new ArrayList<>(Arrays.asList(t.split("")));
		int ls = sList.size();
		int lt = tList.size();
		String str;

		for (String string : sList) {
			str = string;
			tList.remove(str);
		}

		int ops;
		if (ls == lt) {
			ops = tList.size() * 2;
		} else if (ls > lt) {
			ops = (tList.size() * 2) + (ls - lt);
		} else {
			ops = (tList.size() * 2) - (lt - ls);
		}

		System.out.println(ops);
	}
}
