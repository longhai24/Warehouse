package thread;

public class Thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt1 = new MyThread();
		Thread t1=new Thread(mt1,"a");
		MyThread mt2 = new MyThread();
		Thread t2=new Thread(mt2,"b");
		MyThread mt3 = new MyThread();
		Thread t3 = new Thread(mt3,"c");
		t2.start();
		t1.start();
		t3.start();
//		mt2.run();
	}

}
