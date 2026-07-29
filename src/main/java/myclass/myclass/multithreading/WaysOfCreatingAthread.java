package myclass.myclass.multithreading;

// there are two ways to create a thread one is extending the thread classs another one is implementing runnable interfaces

public class WaysOfCreatingAthread {

//	Thread creation using thread classs
    static class ThreadCrationUsingThreadClass extends Thread {
		@Override
		public void run() {
			System.out.println("thread name in run method:" + Thread.currentThread().getName());
		}
	}

//	Thread creation using runable interface
	static class ThreadCrationUsingThreadRunableInterface implements Runnable {
		@Override
		public void run() {
			System.out.println("thread name in run method:" + Thread.currentThread().getName());
		}

	}

	public static void main(String[] args) {
		ThreadCrationUsingThreadClass t1 = new ThreadCrationUsingThreadClass();
		t1.setName("Thread-Class-Thread");
		t1.start();

		// Using Runnable interface
		ThreadCrationUsingThreadRunableInterface runnable = new ThreadCrationUsingThreadRunableInterface();
		
		// We need to create a Thread object when using Runnable
		// because Runnable only defines a task and does not have thread capabilities like start().

		// Runnable interface contains only the task (run method),
		// it does not create or manage a thread.

		// In the case of extending the Thread class,
		// the class itself becomes a thread (worker thread),
		// so it already has the ability to start and execute the task.
		Thread t2 = new Thread(runnable);
		t2.setName("Runnable-Thread");
		t2.start();

		// Main thread
		System.out.println("Thread name: " + Thread.currentThread().getName());
	}
	
	// recommenred thread creating using the implementing the interface because java doesnot suppoer multiple inheritance

}
