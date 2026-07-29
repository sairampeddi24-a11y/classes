package myclass.myclass.multithreading;

public class ThreadMethods extends Thread{
	
	@Override
	public void run() {
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		ThreadMethods tm = new ThreadMethods();
		tm.start();
		tm.getName();
		tm.getPriority();
		tm.run();
		tm.join();
		tm.yield(); // to give the time to exceute other threads
		tm.setDaemon(true); // to set the thread as deamon it run in background jvm doesnt wait for its execution
		tm.interrupt(); // to interupt the thread
		tm.sleep(10000); // to sleep the thread
	}

}
