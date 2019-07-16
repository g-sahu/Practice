package com.practice.java;

public class SystemOutExample {

	public static void main(String[] args) {
		/*PrintStream ps = new PrintStream(System.out);
		ps.println("Hello World!");
		ps.print("Hello World Again!");
		ps.close();*/

		System.out.append("Hello ");
		System.out.append("World");
		System.out.println();

		System.out.println(String.valueOf(null));
	}

}
