package com.contests.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HackLandElection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String votes[] = new String[n];
		
		for(int i=0; i<n; i++) {
			votes[i] = br.readLine();
		}
		
		br.close();
		System.out.println(electionWinner(votes));
	}
	
	static String electionWinner(String votes[]) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int c = 1, max = 1, l = votes.length;
		String winner = null;
		
		for(int i=0; i<l; i++) {
			if(map.containsKey(votes[i])) {
				c = map.get(votes[i]);
				map.put(votes[i], ++c);
				max = c > max ? c : max;
			} else {
				map.put(votes[i], 1);
			}
		}
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		String str = null;
		
		for(Map.Entry<String, Integer> entry : entrySet) {
			if(entry.getValue() == max) {
				str = entry.getKey();
				
				if(winner != null) {
					winner = winner.compareTo(str) < 0 ? str : winner;
				} else {
					winner = str;
				}
			}
		}
		
		return winner;
	}
}
