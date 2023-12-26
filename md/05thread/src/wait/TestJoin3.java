package com.hc.wait;

import java.util.Scanner;

public class TestJoin3 {

	public static void main(String[] args) {
		//  main 线程，  t1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i< 10; i++) {
					System.out.println("in thread t1 " + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}, "线程1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i< 20; i++) {
					System.out.println("in thread t2 " + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		System.out.println("before thread t1 start");
		t1.start();
		t2.start();
		System.out.println("before  t1 join");
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after  t1 join");
		Scanner sc = new Scanner(System.in);
		System.out.println("please input something:");
		String line = sc.nextLine();
		System.out.println("line is "+ line);
		System.out.println("before  t2 join");
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after  t2 join");
		System.out.println("at end of main");
	}
}
