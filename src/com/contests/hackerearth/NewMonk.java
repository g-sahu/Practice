package com.contests.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class NewMonk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<String> completed = new ArrayList<String>();
		
		int n = Integer.parseInt(br.readLine());
		String array = br.readLine();
		
		if(n > 0 && n <= 100000) {
			String arr[] = array.split(" ");
			int l = arr.length;
			int i = 0, lastIndex = 0, d = 0;

			while(i < l) {
				if(!completed.contains(arr[i])) {
					lastIndex = 0;

					for(int j=i+1; j<l; j++) {
						if(arr[i].equals(arr[j])) {
							lastIndex = j;
						}
					}

					if(lastIndex != 0) {
						d = lastIndex - i;
						list.add(d);
					}

					completed.add(arr[i]);
				}

				i++;
			}

			if(!list.isEmpty()) {
				Collections.sort(list);
				System.out.println(list.get(list.size()-1));
			} else {
				System.out.println(-1);
			}
		}
	}
}
