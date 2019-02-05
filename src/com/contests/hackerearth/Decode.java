package com.contests.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Decode {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++) {
			decodeMessage(br.readLine());
		}
		
		br.close();
	}

	static void decodeMessage(String msg) {
		List<Character> list = new ArrayList<Character>();
		int l = msg.length();
		int i = 0;
		int size = list.size();
		int index;

		if(l % 2 == 0) {
			while(i < l) {
				if(i % 2 == 0) {
					index = 0;
				} else {
					index = size;
				}

				list.add(index, msg.charAt(i++));
				size = list.size();
			}
		} else {
			while(i < l) {
				if(i % 2 == 0) {
					index = size;
				} else {
					index = 0;
				}

				list.add(index, msg.charAt(i++));
				size = list.size();
			}
		}
		
		Iterator<Character> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next());
		}
	}
}
