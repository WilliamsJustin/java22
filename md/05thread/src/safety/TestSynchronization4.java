package com.hc.safety;

// 静态的同步方法的锁 ： 例子
class Table {

	// Table.class 
	synchronized static void printTable(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread1 extends Thread {
	public void run() {
		new Table().printTable(1);
		// Table.printTable(1);
	}
}

class MyThread2 extends Thread {
	public void run() {
		new Table().printTable(10);
		// Table.printTable(10);
	}
}

class MyThread3 extends Thread {
	public void run() {
		new Table().printTable(100);
		// Table.printTable(100);
	}
}

class MyThread4 extends Thread {
	public void run() {
		new Table().printTable(1000);
		// Table.printTable(1000);
	}
}

public class TestSynchronization4 {
	public static void main(String t[]) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		MyThread3 t3 = new MyThread3();
		MyThread4 t4 = new MyThread4();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}