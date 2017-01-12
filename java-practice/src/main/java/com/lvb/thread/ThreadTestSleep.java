package com.lvb.thread;


public class ThreadTestSleep {

	public static void main(String[] args) {

		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);

		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 30) {
				thread.start();
				//				try {
				//					thread.sleep(1000); // 使得thread必然能够马上得以执行
				//				} catch (InterruptedException e) {
				//					e.printStackTrace();
				//				}
			}
		}
	}

	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}
	}
}