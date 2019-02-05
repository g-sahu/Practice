package com.contests.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Polygons {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer[]> input = new ArrayList<Integer[]>();
		String[] polygon = null;
		int sq = 0, r = 0, op = 0;
		int a, b, c, d;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		while(s != null) {
			polygon = s.split(" ");
			
			a = Integer.parseInt(polygon[0]);
			b = Integer.parseInt(polygon[1]);
			c = Integer.parseInt(polygon[2]);
			d = Integer.parseInt(polygon[3]);
			
			if((a > 0) && (b > 0) && (c > 0) && (d > 0)) {
				if((a == b) && (b == c) && (c == d)) {
					sq++;
				} else if((a == c) && (b == d)) {
					r++;
				} else {
					op++;
				}
			}else {
				op++;
			}
			
			s = br.readLine();
		}
		
		System.out.print(sq + " " + r + " " + op);
	}
}
