package thread;


/**
 * 
* <p>Title: MyThread</p>  
* <p>Description: </p>  
* @author Apple 

* @date 2019��4��15��
 */
public class MyThread implements Runnable {

	@Override
	public void run() {
		Thread thisT=Thread.currentThread();
		for (int i= 0;i<5;i++) {
			System.out.println("");
			System.out.println(thisT.getName()+"ѭ���˵�"+(i+1)+"��");
		}
	}

}
