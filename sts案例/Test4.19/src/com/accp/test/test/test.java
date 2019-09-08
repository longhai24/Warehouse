package com.accp.test.test;

import java.util.ArrayList;

import com.accp.test.dao.GoodsDao;
import com.accp.test.dao.IGoodsDao;
import com.accp.test.entity.GoodsClass;
import com.accp.test.entity.newG;

/**
 * 
* <p>Title: test</p>  
* <p>Description: 测试类</p>  
* @author Apple 

* @date 2019年4月19日
 */
public class test {

	public static void main(String[] args) {
		IGoodsDao gd = new GoodsDao();
		ArrayList<GoodsClass> li = new ArrayList<>();
		li = gd.SelGoodsClazz();
		for (GoodsClass newG : li) {
			System.out.println(newG);
		}
	}
}
