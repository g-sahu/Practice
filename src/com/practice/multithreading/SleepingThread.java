package com.practice.multithreading;

public class SleepingThread {
	public static void main(String[] args) {
		Runnable r = new SleepingThreadA();
		Thread a = new Thread(r, "Thread A");
		Thread b = new Thread(r, "Thread B");
		a.start();
		b.start();
	}
}

class SleepingThreadA implements Runnable {
	public void run() {
		for(int i=1; i<=100; i++) {
			/*try {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				//System.out.println("Thread is sleeping...");
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}
}
