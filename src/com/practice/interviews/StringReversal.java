package com.practice.interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class StringReversal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string: ");
		String str = br.readLine();
		char arr[] = str.toCharArray();

		StringReversal obj = new StringReversal();
		System.out.println("Reversal with stack: ");
		obj.reverseWithStack(arr);
		
		System.out.println();
		System.out.println("Reversal with swapping: ");
		obj.reverse(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * Reversing a string by swapping characters
	 * @param arr
	 */
	void reverse(char arr[]) {
		int l = arr.length;
		int start = 0;
		int end = l-1;

		while(start < end) {
			swap(arr, start++, end--);
		}
	}
	
	void swap(char arr[], int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	void reverseWithStack(char arr[]) {
		Stack<Character> stack = new Stack<Character>();
		
		for(Character ch: arr) {
			stack.push(ch);
		}
		
		while(!stack.empty()) {
			System.out.print(stack.pop());
		}
	}

}
