package com.hc.wait;

class Customer {
	int amount = 10000;
	// 取钱
	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		while (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed... " + this.amount);
	}

	// 存钱
	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		System.out.println("deposit completed... " + this.amount);
		notify();
	}
}

public class TestWait {
	public static void main(String args[]) {
		final Customer c = new Customer();
		new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(1000);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				c.deposit(7000);
			}
		}.start();
	}
}
