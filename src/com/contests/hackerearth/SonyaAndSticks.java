package com.contests.hackerearth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SonyaAndSticks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Long, Long> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			map.put(sc.nextLong(), sc.nextLong());
		}
		
		sc.close();
		
		System.out.println(minimumSticks(map));
	}
	
	static int minimumSticks(HashMap<Long, Long> map) {
		int c = 1, l;
		long x, h, d;
		
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		l = keys.length;
		
		for(int i=0; i<l-1; i++) {
			x = (Long) keys[i];
			h = map.get(x);
			d = x + h;
			
			if(d >= (Long) keys[i+1]) {
				continue;
			} else {
				c++;
			}
		}
		
		return c;
	}

}
