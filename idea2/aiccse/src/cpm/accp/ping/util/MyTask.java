package cpm.accp.ping.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

import cpm.accp.ping.biz.LoginBiz;
import cpm.accp.ping.entity.Use;

public class MyTask  extends TimerTask{
	LoginBiz biz = new LoginBiz();
	@Override
	public void run() {
		System.out.println("执行监听删除");
		ArrayList<Use> list = biz.selectUses();
		Date day=new Date();  
//		for (Use use : list) {
//			System.out.println(use.getZtime());
//		}
		for (Use use : list) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			try {
				Date i = df.parse(df.format(day)); //系统时间
				if(use.getZtime() == "" || use.getZtime() == null) {
					continue;
				}
				Date j = df.parse(use.getZtime()); // 数据库时间
//				System.out.println(i+"i");
//				System.out.println(j+"j");
//				System.out.println(i.getDate() -j.getDate() +"酷酷酷酷酷酷酷酷酷酷酷酷酷酷酷酷酷酷酷");
				if(i.getDate() - j.getDate() >= 7 && use.getUzing() != 0) { //系统时间-冻结时间 并且 是冻结用户
					biz.deleteRole(use.getUserid().toString());
//					System.out.println("删除用户"+use.getUsername());
				}else {
//					System.out.println("j小于i");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
