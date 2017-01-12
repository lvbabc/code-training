package com.lvb.thread;


public class ThreadTestAll {

	public static void main(String[] args) {
		//		Thread myThread = new Thread() {
		//
		//			@Override
		//			public void run() {
		//				for (int i = 0; i < 100; i++) {
		//					System.out.println("i = " + i);
		//				}
		//			}
		//		};
		Thread myThread1 = new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("myThread 1 --  i = " + i);
				}
			}
		};
		Thread myThread2 = new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("myThread 2 --  i = " + i);
				}
			}
		};
		myThread1.setPriority(Thread.MAX_PRIORITY);
		myThread2.setPriority(Thread.MIN_PRIORITY);


		for (int i = 0; i < 100; i++) {
			System.out.println("main thread i = " + i);
			if (i == 20) {
				//				myThread.setPriority(Thread.MAX_PRIORITY);
				//				myThread.start();
				Thread.yield();
				myThread1.start();
				myThread2.start();
				//对于Thread.yield()静态方法，只需要了解它的作用就是让这个线程从运行状态变成就绪状态，
				//并从就绪队列中取一条优先级比此线程高的线程运行就好了。
			}
		}
	}

}

