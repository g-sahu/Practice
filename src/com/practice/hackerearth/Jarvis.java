package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Jarvis {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		map.put("0", 6);
		map.put("1", 2);
		map.put("2", 5);
		map.put("3", 5);
		map.put("4", 4);
		map.put("5", 5);
		map.put("6", 6);
		map.put("7", 3);
		map.put("8", 7);
		map.put("9", 6);

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			int n;
			String arr[];

			for(int i=0; i<t; i++) {
				n = Integer.parseInt(br.readLine());
				arr = br.readLine().split(" ");
				output.add(findLowest(arr));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		Iterator<Integer> itr = output.iterator();

		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	private static int findLowest(String arr[]) {
		String split[];
		int lowestSum = 0, lowest = 0, num, sum;
		
		for(String s: arr) {
			num = Integer.parseInt(s);
			sum = 0;
			
			if(lowestSum == 0) {
				if(num < 10) {
					lowestSum = map.get(s);
					lowest = num;
				} else {
					split = s.split("");
					sum = 0;
					
					for(String s1: split) {
						sum = sum + map.get(s1);
					}
					
					lowestSum = sum;
					lowest = num;
				}
			} else if(lowestSum > 0 && num < 10) {
				sum = map.get(s);
				
				if(sum < lowestSum) {
					lowestSum = sum;
					lowest = num;
				}
			} else if(lowestSum > 0 && num >= 10) {
				split = s.split("");
				sum = 0;
				
				for(String s1: split) {
					sum = sum + map.get(s1);
				}
				
				if(sum < lowestSum) {
					lowestSum = sum;
					lowest = num;
				}
			}
		}
	
		return lowest;
	}
}
