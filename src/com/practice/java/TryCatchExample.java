package com.practice.java;

import java.io.IOException;

public class TryCatchExample {

	public static void main(String[] args) throws IOException {
		try {
			//throw new IOException();
			System.out.println(doSomething());
		} finally {
			System.out.println("Finally!");
		}
	}
	
	static String doSomething() {
		try {
			return "try";
		} finally {
			return "finally";
		}
	}

}
