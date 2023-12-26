package com.hc.safety;

public class TestDeadLock {

	public static void main(String[] args) {
		final String lock1 = "aaa";
		final String lock2 = "bbb";
		System.out.println(lock1 == lock2);

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock1) {
					System.out.println(" 准备吃肉");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock2) {
						System.out.println(" 我 想吃肉");
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock2) {
					System.out.println(" 准备喝酒");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					synchronized (lock1) {
						System.out.println(" 我 想喝酒");
					}
				}
			}

		}).start();
	}
}
