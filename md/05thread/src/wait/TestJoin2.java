package com.hc.wait;

public class TestJoin2 {

	public static void main(String[] args) {
		//  main 线程，  t1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				Thread t2 = new Thread(new Runnable() {
					@Override
					public void run() {
						for(int i=0; i< 10; i++) {
							System.out.println(Thread.currentThread() + " " + i);
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} 
					
				});
				t2.start();
				System.out.println("in thread 1");
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("at end of thread 1");
			}
			
		});
		
		t1.start();
		System.out.println("at end of main");
	}
}
