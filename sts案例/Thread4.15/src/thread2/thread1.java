package thread2;

public class thread1 {

	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		Thread t1 = new Thread(mt1, "1");
		MyThread2 mt2 = new MyThread2();
		Thread t2 = new Thread(mt2, "2");
		t1.setPriority(10);
		t2.setPriority(6);
		t1.start();
		t2.start();
	}

}
