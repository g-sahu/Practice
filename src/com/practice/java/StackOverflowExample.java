package com.practice.java;

import java.util.ArrayList;
import java.util.List;

public class StackOverflowExample {
	private static int i = 0;
	
	public static void main(String[] args) {
		StackOverflowExample obj = new StackOverflowExample();
		//obj.recursive();
		
		while(true) {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			System.out.println(i++);
		}
	}
	
	private void recursive() {
		System.out.println(i++);
		recursive();
	}
}
