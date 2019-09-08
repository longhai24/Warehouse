package thread2;

public class MyThread implements Runnable {

	@Override
	public void run() {
		Thread thisT = Thread.currentThread();
		for (int i = 0; i <10; i++) {
			System.out.println(thisT.getName()+"ÔÚÔËĞĞ");
		}
	}

}
