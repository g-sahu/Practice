package com.contests.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Monk {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> input;
		String s = br.readLine();
		String arr[];
		String num[];
		int t, n, k;
		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		while(sc.hasNext()) {
			System.out.println(sc.nextInt());
		}
		
		sc.close();
		t = Integer.parseInt(s);
		
		if(t > 0 && t <= 10) {
			for(int i=1; i<=t; i++) {
				input = new ArrayList<Integer>();
				s = br.readLine();
				arr  = s.split(" ");
				n = Integer.parseInt(arr[0]);
				k = Integer.parseInt(arr[1]);

				if(k > n) {
					list.add(0);
					continue;
				}

				s = br.readLine();
				num = s.split(" ");

				for(String j: num) {
					input.add(Integer.parseInt(j));
				}

				list.add(calculatePower(input, n, k));
			}

			Iterator<Integer> itr = list.iterator();

			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
	}
	
	static int calculatePower(ArrayList<Integer> input, int n, int k) {
		int max = 1;
		
		for(int i=1; i<=k; i++) {
			if(input.get(0) < input.get(n-1)) {
				input.remove(0);				
			} else {
				input.remove(n-1);
			}
			
			n--;
		}
		
		if(input.isEmpty()) {
			return 0;
		}
		
		Iterator<Integer> itr = input.iterator();
		while(itr.hasNext()) {
			max = max * itr.next();
		}
		
		return max;		
	}
}
