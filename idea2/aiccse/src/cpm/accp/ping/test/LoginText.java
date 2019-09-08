package cpm.accp.ping.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cpm.accp.ping.biz.LoginBiz;
import cpm.accp.ping.util.PwdUilt;

public class LoginText {

	public static void main(String[] args) {
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			Date i = df.parse(df.format(day));
			Date j = df.parse("2019-04-15");
			System.out.println(i+"i");
			System.out.println(j+"j");
			if(j.getTime() > i.getTime()) {
				System.out.println("j大于i");
			}else {
				System.out.println("j小于i");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
