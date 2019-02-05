package com.contests.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class LexicalSorting {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> inputList = new ArrayList<ArrayList<String>>();
		ArrayList<String> inputString;
		String str;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			int n;
			
			for(int i=0; i<t; i++) {
				n = Integer.parseInt(br.readLine());
				inputString = new ArrayList<>();
				
				for(int j=0; j<n; j++) {
					inputString.add(br.readLine());
				}
				
				inputList.add(inputString);
			}
			
			Iterator<ArrayList<String>> itr = inputList.iterator();
			
			while(itr.hasNext()) {
				inputString = itr.next();
				
				Iterator<String> sItr = inputString.iterator();
				
				while(sItr.hasNext()) {
					str = sItr.next();
					
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
