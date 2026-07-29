package myclass.myclass.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LocksInJava {

	static class Display {
		// method kept as normal method so uneven results like kill don don kill kill don like this 
		public void wish(String name) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello ->" + name);
				try {
					Thread.sleep(2000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// after printing the one complete thing lock will be released
		public synchronized void synchronisedwish(String name) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello ->" + name);
				try {
					Thread.sleep(2000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		ReentrantLock l = new ReentrantLock();
		public  void usingLock(String name) {
			
			l.lock();
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello ->" + name);
				try {
					Thread.sleep(2000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			l.unlock();
		}
		static ReentrantLock l2 = new ReentrantLock();
		public void trylock(String name) {
			if(l2.tryLock()) {
				System.out.println("Thread name got lock :"+Thread.currentThread().getName());
				try {
					Thread.sleep(2000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				l2.unlock();
			}else {
				System.out.println("Thread name not got lock :"+Thread.currentThread().getName());
			}
		}
	}

	static class Mythread extends Thread {
		
		Display d ;
		String name ;
		public Mythread(Display d ,String name) {
			this.d = d;
			this.name = name;
		}
		public void run() {
		//	d.wish(name);
		//	d.synchronisedwish(name);
		// d.usingLock(name);
			d.trylock(name);
		}
	}

		public static void main(String[] Args) {
          Display d = new Display();
          Mythread t1= new Mythread(d,"Don");
          Mythread t2= new Mythread(d,"Kill");
          t1.start();
          t2.start();
		}
	
}
