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
* <p>Description:���߳��� </p>  
* @author Apple 

* @date 2019��4��16��
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
				System.out.println("ִ��ɾ��");
				gbiz.DeleteUser(u.getUserid());
				System.out.println("ɾ�����");
			}
		}
	}

	

	
}
