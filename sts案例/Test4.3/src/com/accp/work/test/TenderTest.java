package com.accp.work.test;

import java.util.ArrayList;

import com.accp.work.dao.TenderDao;
import com.accp.work.entity.Tender;

public class TenderTest {

	/**
	 * 
	 * <p>Title: main</p>  
	 * <p>Description:≤‚ ‘¿‡ </p>  
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TenderDao td = new TenderDao();
		ArrayList<Tender> li = td.getAll();
		Tender li2 = td.get(2);
		System.out.println(li2);
	}

}
