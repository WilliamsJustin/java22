package com.hc.wait;

import java.util.Random;

class Customer2 {
	int amount = 0;
	// 取钱
	synchronized void withdraw(int amount) {
		System.out.println("要去取钱了， 金额： " + amount);

		while (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed... " + this.amount);
		notify();
	}

	// 存钱
	synchronized void deposit(int amount) {
		System.out.println("要去存钱了， 金额： " + amount);
		while( this.amount > 20000) {
			System.out.println("太多钱了， 请来取。 余额：" + this.amount);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.amount += amount;
		System.out.println("deposit completed... " + this.amount);
		notify();
	}
}

public class TestWaitOK {
	public static void main(String args[]) {
		final Customer2 c = new Customer2();
		final Random random = new Random();

		Runnable with = new Runnable() {
			@Override
			public void run() {
				while(true) {
					c.withdraw(random.nextInt(4500) + 500);
					try {
						Thread.sleep(random.nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} 
		};
		
		Runnable depo = new Runnable() {
			@Override
			public void run() {
				while(true) {
					c.deposit(random.nextInt(4500) + 500);
					try {
						Thread.sleep(random.nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} 
		};
		
		new Thread(with).start();
		new Thread(depo).start();
		new Thread(depo).start();
		new Thread(depo).start();
		new Thread(depo).start();
		new Thread(depo).start();
		new Thread(depo).start();
	}
}
