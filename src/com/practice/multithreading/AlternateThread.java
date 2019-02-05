package com.practice.multithreading;

public class AlternateThread {
	public static void main(String[] args) {		
		Runnable r = new RunnableA();		
		Thread a = new Thread(r, "Thread A");
		Thread b = new Thread(r, "Thread B");
		
		a.start();
		b.start();
	}
}

class RunnableA implements Runnable {
	Mutex m = new Mutex();

	public void run() {
		String name;

		while(m.x < 10) {
			synchronized(m) {
				name = Thread.currentThread().getName();
				System.out.println(name + ": " + m.x++);

				try {
					m.notify();
					m.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				m.notify();
			}
		}
	}
}

class Mutex {
	public int x;
}