package com.hc.safety;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSale3 {

	public static void main(String[] args) {
		final String str = new String("aaa");
		Runnable point = new Runnable() {
			public int ticketNum = 30;
			Random random = new Random();
			// 再进入锁 。
			Lock lock = new ReentrantLock();

			@Override
			public void run() {
				int count = 0;
				while (true) {
					// 同步代码 块， 原子性 每次只要一个 线程可以 执行这个代码块， 而且 必须 完成后，其他线程 才能执行这个代码块
					// 卖票
					// 加锁
					lock.lock();
					try {
						// int i = 100 / 0;
						if (ticketNum <= 0) {
							// lock.unlock();
							break;
						}
						System.out.println(Thread.currentThread().getName() + " 卖了票， 票的 ID " + ticketNum);
						count++;
						ticketNum--;
					} finally {
						lock.unlock();
					}
					// 解锁
					try {
						Thread.sleep(random.nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "总共卖了 " + count);
			}
		};

		// 售票点 1
		new Thread(point, "窗口1").start();
		// 售票点 2
		new Thread(point, "窗口2").start();
		// 售票点 3
		new Thread(point, "窗口3").start();
	}
}
