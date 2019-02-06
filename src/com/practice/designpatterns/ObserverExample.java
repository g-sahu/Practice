package com.practice.designpatterns;

public class ObserverExample {
	public static void main(String[] args) {
		MySubject m = new MySubject();
		m.registerObserver(new MyObserver());
		m.setX(5);
	}
}

interface IObserver {
	void update();
}

class MyObserver implements IObserver {
	public void update() {
		System.out.println("State changed!");
	}
}

class MySubject {
	IObserver obs;
	int x;
	
	void setX(int value) {
		x = value;
		obs.update();
	}
	
	void registerObserver(IObserver obs) {
		this.obs = obs;
	}
}
