package com.practice.multithreading;

public class JoinExample {

	public static void main(String[] args) {
		System.out.println("Main thread starts...");
		Thread t1 = new Thread(new Thread1(), "T1");
		t1.start();
		
		String name = Thread.currentThread().getName();
		System.out.println("Main thread resumes...");
		
		for(int i=10; i>0; i--) {
			System.out.println(name + ": " + i);
		}
	}
}

class Thread1 implements Runnable {
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " running...");
		
		for(int i=300; i>0; i--) {
			System.out.println(name + ": " + i);
			
			if(i == 150) {
				Thread t2 = new Thread(new Thread2(), "T2");
				//t2.start();
				
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Thread2 implements Runnable {
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " running...");
		
		for(int i=300; i>0; i--) {
			System.out.println(name + ": " + i);
		}
	}
}
