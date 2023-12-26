package com.hc.wait;

public class TestWait1 {

	public static void main(String[] args) {
		// main 线程， t1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				String lock = new String("aaa");
				for (int i = 0; i < 10; i++) {
					System.out.println("in thread t1 " + i);
					synchronized (lock) {
						try {
							// 会 释放 锁资源，
							lock.wait();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		t1.start();

		System.out.println("at end of main");
	}
}
