package com.lvb.thread;

public class ThreadTest2 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 3) {
				Runnable myRunnable = new MyRunnable();
				Thread thread = new MyThread(myRunnable);
				thread.start();
			}
		}
	}
}

class MyRunnable implements Runnable {

	private int i = 0;

	@Override
	public void run() {
		System.out.println("in MyRunnable run");
		for (i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}

class MyThread extends Thread {

	private int i = 0;

	public MyThread(Runnable runnable) {
		super(runnable);
	}

	@Override
	public void run() {
		System.out.println("in MyThread run");
		for (i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
