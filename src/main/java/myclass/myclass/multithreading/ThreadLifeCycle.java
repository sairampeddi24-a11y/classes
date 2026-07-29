package myclass.myclass.multithreading;

public class ThreadLifeCycle extends Thread{
	
	@Override
	public void run() {
		System.out.println("thread is running");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLifeCycle c = new ThreadLifeCycle();
		System.out.println(c.getState()); // new state
		c.start(); // thread is in state of runable
		System.out.println(c.getState());
		Thread.sleep(100); // main thread will sleep for 100 milli seconds the run thread gets some time
		System.out.println(c.getState()); // it is in time waiting state
		c.join(); // wait until the c thread complete its execution
		System.out.println(c.getState()); // thread is terminated as it's ends the execution
		
		
		
	}

}
