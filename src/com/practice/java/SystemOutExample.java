package com.practice.java;

import java.io.PrintStream;

public class SystemOutExample {

	public static void main(String[] args) {
		PrintStream ps = new PrintStream(System.out);
		ps.println("Hello World!");
		ps.print("Hello World Again!");

		ps.close();
	}

}
