package com.practice.interviews;

public class DiamondProblem {
	public static void main(String args[]) {
		ParentA a = new ChildA();
		ParentB b = new ChildA();
		a.doSomething();
		b.doSomething();
	}
}

class ParentA {
	public void doSomething() {
		System.out.println(getClass().getName());
	}
	
}

class ChildA extends ParentA implements ParentB {
	public void doSomething() {
		super.doSomething();
		System.out.println(getClass().getName());		
	}
}

interface ParentB {
	void doSomething();
}
