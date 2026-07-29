package myclass.myclass.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureIn {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			Future<Integer> out = service.submit(() -> 10);
			out.get();
			out.get(3, TimeUnit.SECONDS);
			out.cancel(true);
			out.isCancelled();
			out.isDone();
		}
		service.shutdown();

	}

}
