package myclass.myclass.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockWithRetry {
	static class Display {

		static ReentrantLock l2 = new ReentrantLock();

		public void trylock(String name) {
			if (l2.tryLock()) {
				System.out.println("Thread name got lock :" + Thread.currentThread().getName());
				try {
					Thread.sleep(2000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				l2.unlock();
			} else {
				System.out.println("Thread name not got lock :" + Thread.currentThread().getName());
			}
		}

		public void trylockwithRetry(String name) {
			try {
				do {
					if (l2.tryLock(5000, TimeUnit.MILLISECONDS)) {
						System.out.println("Thread name got lock :" + Thread.currentThread().getName());
						try {
							Thread.sleep(20000l);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						l2.unlock();
						break;
					} else {
						System.out.println("Thread name not got lock retring again :" + Thread.currentThread().getName());
					}

				} while (true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class Mythread extends Thread {

		Display d = new Display();
		String name;

		public Mythread(String name) {

			this.name = name;
		}

		public void run() {

			// d.trylock(name);
			d.trylockwithRetry(name);
		}
	}

	public static void main(String[] Args) {

		Mythread t1 = new Mythread("Don");
		Mythread t2 = new Mythread("Kill");
		t1.start();
		t2.start();
	}
}
