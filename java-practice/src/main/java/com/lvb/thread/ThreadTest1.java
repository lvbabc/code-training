package com.lvb.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest1 {

	private static int i = 0;
	private final static Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 30) {
				Runnable myRunnable = new MyRunnable("hahaha"); // 创建一个Runnable实现类的对象
				Thread thread1 = new Thread(myRunnable); // 将myRunnable作为Thread target创建新的线程
				Thread thread2 = new Thread(myRunnable);
				Thread thread3 = new Thread(myRunnable); // 将myRunnable作为Thread target创建新的线程
				Thread thread4 = new Thread(myRunnable);
				thread1.start(); // 调用start()方法使得线程进入就绪状态
				thread2.start();
				thread3.start(); // 调用start()方法使得线程进入就绪状态
				thread4.start();

				//				Thread myThread1 = new MyThread("one"); // 创建一个新的线程  myThread1  此线程进入新建状态
				//				Thread myThread2 = new MyThread("two"); // 创建一个新的线程 myThread2 此线程进入新建状态
				//				myThread1.start(); // 调用start()方法使得线程进入就绪状态
				//				myThread2.start(); // 调用start()方法使得线程进入就绪状态

				//				ThreadTest test = new ThreadTest();
				//				new Thread(test.new MyRunnable()).start();
			}
		}
	}

	public static class MyRunnable implements Runnable {

		String aString ;
		public MyRunnable(String areaCode) {
			this.aString=areaCode;
		}

		@Override
		public void run() {
			System.out.println(aString);
		}
	}

	public static class MyThread extends Thread {

		private int i = 0;

		public MyThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			for (i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}
	}
}
