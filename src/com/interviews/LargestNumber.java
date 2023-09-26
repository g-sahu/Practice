package com.interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LargestNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int t = Integer.parseInt(br.readLine());
		System.out.println(findLargest(n, t));
	}

	static long findLargest(String n, int t) {
		String arr[] = n.split("");
		int index = 0, start = 0, end = 0;
		String temp;
		
		while(t > 0) {
			end = start + t;
		    index = getLargestIndex(arr, start, end);
		    
		    while(index > start && t > 0) {
		        temp = arr[index];
		        arr[index] = arr[index-1];
		        arr[index-1] = temp;
		        index--;
		        t--;
		    }
		    
		    start++;
		}
		
		String largest = Arrays.toString(arr).replace("[", "").replace("]", "").replace(", ", "");
		return Long.parseLong(largest);
	}
	
	static int getLargestIndex(String[] arr, int start, int end) {
		int max = Integer.parseInt(arr[start]);
		int index = 0;

		for(int i=start; i<=end; i++) {
			if(max < Integer.parseInt(arr[i])) {
				max = Integer.parseInt(arr[i]);
				index = i;
			}
		}

		return index;
	}
}
