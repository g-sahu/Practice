package com.practice.java;

public class StaticExample {
	private static String message = "Class member";
	
	static {
		message = "Static block member";
	}

	public static void main(String[] args) {
		System.out.println(message);
		StaticExample obj = null;
		obj.foo();		
	}
	
	public static void foo(){
		System.out.println("Test foo called");
	}
}
