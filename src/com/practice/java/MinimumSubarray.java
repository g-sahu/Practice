package com.practice.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MinimumSubarray {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        } else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int arr_size = 0;
        arr_size = Integer.parseInt(in.nextLine().trim());
        int[] arr = new int[arr_size];
        
        for(int i = 0; i < arr_size; i++) {
            int arr_item;
            arr_item = Integer.parseInt(in.nextLine().trim());
            arr[i] = arr_item;
        }

        res = degreeOfArray(arr);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
        in.close();
	}
	
	static int degreeOfArray(int[] arr) {
		int deg = 1, min = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int l = arr.length;
		int max = 1, c;
		
		for(int i=0; i<l; i++) {
			if(map.containsKey(arr[i])) {
				c = map.get(arr[i]) + 1;
				max = c > max ? c : max;
				map.put(arr[i], c);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<Integer, Integer>> itr = entrySet.iterator();
		Map.Entry<Integer, Integer> entry = null;
		List<Integer> list = new ArrayList<Integer>();
		int value = 0;
		
		while(itr.hasNext()) {
			entry = itr.next();
			value = entry.getValue();
			
			if(value == max) {
				list.add(entry.getKey());
			}
		}
		
		return min;
    }

}
