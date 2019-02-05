package com.contests.hackerearth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Help {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, Integer> stationMap = new HashMap<Integer, Integer>();;
		int stops = 0, diff;
		Integer stationDist [];
		
		for(int i=0; i<n; i++) {
			stationMap.put(sc.nextInt(), sc.nextInt());
		}
		
		int d = sc.nextInt();
		int p = sc.nextInt();
		sc.close();
		
		if(p < d) {
			diff = d-p;
			Set<Integer> set = stationMap.keySet();
			stationDist = (Integer[]) set.toArray();
			Arrays.sort(stationDist);
			
			for(int i=0; i<stationDist.length; i++) {
				if(stationDist[i] >= diff) {
					
				}
			}
		}

		System.out.println(stops);
	}

}
