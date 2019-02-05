package com.practice.java;

public class AbstractClassDemo {

	public static void main(String[] args) {
		//AbstractClass obj = new AbstractClass();
		AbstractClass obj = new ChildClass();
		obj.show();
	}

}

abstract class AbstractClass {
	public AbstractClass() {
		System.out.println("Constructor: AbstractClass");
	}
	
	abstract void show();
}

class ChildClass extends AbstractClass {
	public ChildClass() {
		super();
		System.out.println("Constructor: " + getClass().getName());
	}
	
	void show() {
		System.out.println("Show: " + getClass().getName());
	}
}
