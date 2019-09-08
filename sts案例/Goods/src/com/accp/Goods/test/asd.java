package com.accp.Goods.test;

import com.accp.Goods.util.CountDate;

public class asd {

	
	public static void main(String[] args) {
		CountDate cd = new CountDate();
		String time = cd.getCurrentDay();
	String Adate = cd.fTime2(time, 7);
		//Integer i = cd.getDistanceOfTwoDate("2019-4-15", "2019-4-16");
		System.out.println(Adate);
	}

}
