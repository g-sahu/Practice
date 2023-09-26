package com.interviews;

import java.util.Stack;

public class BalanceParentheses {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		final char SQUARE_OPEN = '[';
		final char SQUARE_CLOSED = ']';
		final char CURLY_OPEN = '{';
		final char CURLY_CLOSED = '}';
		final char ROUND_OPEN = '(';
		final char ROUND_CLOSED = ')';
		
		String str = "{{[[(())]]}}";
		char[] arr = str.toCharArray();
		char item;
		int i = 0;
		
		for(char c: arr) {
			if(i == 0) {
				stack.push(c);
			} else  if(c == SQUARE_OPEN || c == CURLY_OPEN || c == ROUND_OPEN) {
				stack.push(c);
			} else {
				if(!stack.isEmpty()) {
					item = stack.pop();

					if((c == SQUARE_CLOSED && item == SQUARE_OPEN) 
							|| (c == CURLY_CLOSED && item == CURLY_OPEN) 
							|| (c == ROUND_CLOSED && item == ROUND_OPEN)) {
						i++;
						continue;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			
			i++;
		}
		
		if(stack.isEmpty() && i == arr.length) {
			System.out.println("Balanced ");
		} else {
			System.out.println("Unbalanced");
		}
	}
}
