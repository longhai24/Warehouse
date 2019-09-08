package com.accp.Goods.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.accp.Goods.listener.MyThread;
import com.accp.Goods.util.Encryption;

/**
 * 
* <p>Title: Test</p>  
* <p>Description:测试类 </p>  
* @author Apple 

* @date 2019年4月15日
 */
public class Test {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		t.start();
		// TODO Auto-generated method stub
	}

}
