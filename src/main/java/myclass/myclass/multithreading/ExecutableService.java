package myclass.myclass.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutableService {
	
	
	public void service() {
		ExecutorService service = Executors.newFixedThreadPool(2);
	
		for(int i =0; i<5;i++) {
			int i1 = i;
			service.execute(() -> System.out.println("thread :"+Thread.currentThread().getName()+" task-no :"+i1));
		}
		service.shutdown();
	}
	
	public static void main (String [] args) {
		ExecutableService service = new ExecutableService();
		service.service();
	}
	
	public int add(int a,int b) {
		  return a+b;
	}

}
