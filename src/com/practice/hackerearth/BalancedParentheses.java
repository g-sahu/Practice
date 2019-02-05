package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer x;
		
		for(int j=0; j<n; j++) {
			input.add(sc.nextInt());
		}
		
		sc.close();
		
		Stack<Integer> stack = new Stack<Integer>();
		Iterator<Integer> itr = input.iterator();
		int c = 0, longest = 0;
		
		while(itr.hasNext()) {
			x = itr.next();
			
			if(Integer.signum(x) == 1) {
				stack.push(x);
			} else if(!stack.isEmpty()) {
				if(stack.pop() == -x) {
					c = c + 2;
					
					if(stack.isEmpty()) {
						if(!itr.hasNext()) {
							longest = c > longest ? c : longest;
							break;
						} else {
							longest = c > longest ? c : longest;
							//c = 0;
						}
					} else {
						longest = c > longest ? c : longest;
					}
				} else {
					c = 0;
					stack.clear();
				}
			} else {
				c = 0;
			}			
		}
		
		System.out.println(longest);
	}
}
