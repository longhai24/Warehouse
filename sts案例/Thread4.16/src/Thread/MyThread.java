package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
* <p>Title: MyThread</p>  
* <p>Description: </p>  
* @author Apple 

* @date 2019��4��16��
 */
public class MyThread implements Runnable {

	Lock lo = new ReentrantLock();
	@Override
	public void run() {
		lo.lock();
		Thread thisT=Thread.currentThread();
		System.out.println(thisT.getName()+"��ɽ��");
		try {
			thisT.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lo.unlock();
	}

}
