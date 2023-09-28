package com.practice.java;

public class PolymorphismEx extends MyAbstractClass implements MyInterface {
	public static void main(String[] args) {
		new PolymorphismEx().show();
	}

	@Override
	public void show() {
		System.out.println("Polymorphism test.");
	}
}

interface MyInterface {
	void show();
}

abstract class MyAbstractClass {
	abstract void show();
}
