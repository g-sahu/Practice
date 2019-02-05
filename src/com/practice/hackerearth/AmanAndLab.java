package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AmanAndLab {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> dup;
		int t = 0;
		
		for(int i=1; i<=n; i++) {
			t = sc.nextInt() + sc.nextInt();
			list.add(t);
			
			if(map.containsKey(t)) {
				dup = map.get(t);
				dup.add(i);
				map.put(t, dup);
			} else {
				dup = new ArrayList<Integer>();
				dup.add(i);
				map.put(t, dup);
			}
		}
		
		sc.close();
		Collections.sort(list);
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			dup = map.get(itr.next());
			
			if(dup.size() > 1) {
				Collections.sort(dup);
			}
			
			for(Integer i: dup) {
				System.out.print(i + " ");
			}
		}
	}

}
