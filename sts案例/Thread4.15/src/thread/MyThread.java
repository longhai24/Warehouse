package thread;


/**
 * 
* <p>Title: MyThread</p>  
* <p>Description: </p>  
* @author Apple 

* @date 2019年4月15日
 */
public class MyThread implements Runnable {

	@Override
	public void run() {
		Thread thisT=Thread.currentThread();
		for (int i= 0;i<5;i++) {
			System.out.println("");
			System.out.println(thisT.getName()+"循环了第"+(i+1)+"次");
		}
	}

}
