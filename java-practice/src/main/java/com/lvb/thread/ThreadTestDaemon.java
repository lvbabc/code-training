package com.lvb.thread;


public class ThreadTestDaemon {

	public static void main(String[] args) {
		Thread myThread = new MyThread();
		for (int i = 0; i < 100; i++) {
			System.out.println("main thread i = " + i);
			if (i == 20) {
				myThread.setDaemon(true);
				myThread.start();
			}
		}
	}


	static class MyThread extends Thread {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println("i = " + i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}