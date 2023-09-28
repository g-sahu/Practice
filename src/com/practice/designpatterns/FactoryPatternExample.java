package com.practice.designpatterns;

import java.util.HashMap;
import java.util.Map;

public class FactoryPatternExample {
	public static void main(String[] args) {
		MyFactory mf = new MyFactory();
		MyClass mc = mf.getInstance("CLASS_B");
		mc.show();
	}
}

class MyFactory {
	public MyClass getInstance(String str) {
		switch(str) {
			case "CLASS_A":
				return new ClassA();
				
			case "CLASS_B":
				return new ClassB();
				
			default:
				return null;
		}
	}
}

class ClassA implements MyClass {
	public void show() {
		System.out.println(getClass().getName());
	}
}

class ClassB implements MyClass {
	public void show() {
		System.out.println(getClass().getName());
		
		Map<String, String> map = new HashMap<>();
		map.put(null, null);
		map.put(null, "Not null");
		System.out.println(map.get(null));
	}
}

interface MyClass {
	void show();
}
