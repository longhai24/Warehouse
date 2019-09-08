package com.accp.tow.test;

import java.util.ArrayList;

import com.accp.tow.biz.TenderBiz;
import com.accp.tow.entity.BidEntity;
import com.accp.tow.entity.TenderEntity;

public class TenderTest {
	public static void main(String[] args) {
		//创建测试对象
		TenderBiz biz = new TenderBiz();
		ArrayList<BidEntity> list = biz.selectbid("8");
		//循环输出测试集合
		for (BidEntity i : list) {
			System.out.println(i);
		}
//		int i = biz.delete("3");
//		System.out.println(i);
	}
}
