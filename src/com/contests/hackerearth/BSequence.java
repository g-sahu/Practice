package com.contests.hackerearth;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * B-Sequence
 * Any sequence A of size n is called B-sequence if:
 * 	a)	A1 < A2 < ... < Ak > Ak+1 > Ak+2 > ... > An where 1 <= k <= n. 
 * 		That is, a sequence which is initially strictly increasing and then strictly decreasing (the decreasing part may or may not be there).
 * 	b)	All elements in A except the maximum element comes atmost twice (once in increasing part and once in decreasing part) and maximum element comes exactly once.
 * 	c)	All elements coming in decreasing part of sequence should have come once in the increasing part of sequence.
 * 
 * You are given a B-sequence S and Q operations. For each operation, you are given a value val. 
 * You have to insert val in S if and only if after insertion, S still remains a B-sequence.
 * After each operation, print the size of S. After all the operations, print the sequence S.
 * 
 * Hint: Think of using some data structure to support insertion of elements in complexity better than linear.
 * 
 * Input Format:
 * First line consists of an integer N, denoting size of S. 
 * Second line consists of N space separated integers, denoting elements of S.
 * Next line consists of an integer Q, denoting number of operations.
 * Each of the following Q lines consists of an integer val.
 * 
 * Output Format:
 * After each operation, print the size of S in a new line.
 * After all operations, print the sequence S.
 * @author gasahu
 *
 */
public class BSequence {
	private static Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
	private static int size, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x=0, q=0, val=0;
		
		for(int i=0; i<n; i++) {
			x = sc.nextInt();
			
			if(map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
			
			max = x > max ? x : max;
			size++;
		}
		
		q = sc.nextInt();
		
		for(int i=0; i<q; i++) {
			val = sc.nextInt();
			modifySequence(val);
			System.out.println(size);
		}
		
		sc.close();
		printSequence();
	}
	
	static void modifySequence(int val) {
		if(val != max) {
			if(map.containsKey(val)) {
				if(map.get(val) == 1) {
					map.put(val, map.get(val) + 1);
					size++;
				}
			} else {
				map.put(val, 1);
				size++;
			}
		}
	}
	
	static void printSequence() {
		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
		int arr[] = new int[size];
		Iterator<Map.Entry<Integer, Integer>> mapIterator = entrySet.iterator();
		Map.Entry<Integer, Integer> entry = null;
		int beg = 0, end = size - 1;
		int val;
		
		while(mapIterator.hasNext()) {
			entry = mapIterator.next();
			val = entry.getValue();
			arr[beg++] = entry.getKey();
			
			if(val == 2) {
				arr[end--] = entry.getKey();
			}
		}
		
		for(Integer i: arr) {
			System.out.print(i + " ");
		}		
	}
}