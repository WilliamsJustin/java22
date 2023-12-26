package com.hc.safety;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestSale2 {

	public static void main(String[] args) {
		
		Task.doit();
		
		final String str = new String("aaa");
		Runnable point = new Runnable() {
			public volatile int ticketNum = 30;
			Random random = new Random();

			public synchronized void showNum() {
				// System.out.println(ticketNum);
			}
			
			// 方法的对象 锁 是 谁 ？  this 
			public synchronized boolean saleOne() {
				if (ticketNum <=  0)  { 
					return false; 
				}
				System.out.println(Thread.currentThread().getName() + " 卖了票， 票的 ID " + ticketNum);
				ticketNum--;
				return true;
			}

			@Override
			public void run() {
				int count = 0;
				while (true) {
					// 同步代码 块， 原子性 每次只要一个 线程可以 执行这个代码块， 而且 必须 完成后，其他线程 才能执行这个代码块
					if (!saleOne()) {
						break;
					}
					count++;
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

// 对象 和 方法区里面 存在 一个 对象：  Task.class, 
class Task implements Runnable {
	public static int aaa;
	// private AtomicBoolean bbb;
	
	// 用的 对象 锁 是 谁 ？   this ？  Task.class
	public static synchronized void doit() {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
