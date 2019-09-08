package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread t1 = new MyThread();
		ExecutorService pool1 = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			pool1.execute(t1);
		}
	}

}
