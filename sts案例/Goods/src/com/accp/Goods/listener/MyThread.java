package com.accp.Goods.listener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.accp.Goods.biz.GoodsBiz;
import com.accp.Goods.entity.Users;
import com.accp.Goods.util.CountDate;

/**
 * 
* <p>Title: Thread</p>  
* <p>Description:多线程类 </p>  
* @author Apple 

* @date 2019年4月16日
 */
public class MyThread extends TimerTask {

	@Override
	public void run() {
		
		GoodsBiz gbiz = new GoodsBiz();
		ArrayList<Users> ulist =gbiz.SelLogoutUser();
		CountDate cd = new CountDate();
		String now = cd.getCurrentDay();
		
		System.out.println();
 		for (Users u : ulist) {
			if (cd.getDistanceOfTwoDate(now,u.getDtime())==7) {
				System.out.println("执行删除");
				gbiz.DeleteUser(u.getUserid());
				System.out.println("删除完成");
			}
		}
	}

	

	
}
