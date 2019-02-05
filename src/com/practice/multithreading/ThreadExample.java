package com.practice.multithreading;

public class ThreadExample {
	int i;
	
	public static void main(String args[] ) throws Exception {
		Runnable r = new ThreadA();
		Thread a = new Thread(r, "Thread A");
		Thread b = new Thread(r, "Thread B");
		
		a.start();
		b.start();
	}
}

class ThreadA extends ThreadExample implements Runnable {
	public void run() {
		synchronized(this) {
			while(i < 100) {
				System.out.println(Thread.currentThread().getName() + " : " + i++);

				if(i == 50) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			notify();
		}
		
		//Baaki ka kaam karenge
	}
}