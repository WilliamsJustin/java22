package com.hc.wait;

public class TestJoin4 {

	public static void main(String[] args) {
		// main 线程， t1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Thread t2 = new Thread(new Runnable() {
					@Override
					public void run() {
						for(int i = 0; i < 10; i++) {
							System.out.println(Thread.currentThread() + " " + i);
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}, "线程 2 ");
				t2.start();
				System.out.println("at thread t1");
				System.out.println("before join into t1");
				try {
					t2.join();
					System.out.println("after join into t1");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("at end of thread t1");
			}

		});

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("at end of main");
	}
}
