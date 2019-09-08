package com.accp.test;

import java.util.List;

import org.junit.Test;

import com.accp.biz.biz;
import com.accp.pojo.Air_quality_index;
import com.accp.pojo.District;
import com.accp.util.CgLibTransProxyUtil;

public class test {
	private biz biz = CgLibTransProxyUtil.getTransProxyObject(biz.class);
	@Test
	public void fins() {
		List<Air_quality_index> list = biz.finds();
		for (Air_quality_index a : list) {
			System.out.println(a);
		}
	}
	@Test
	public void findDs() {
		List<District> listdis = biz.findDiss();
		for (District d : listdis) {
			System.out.println(d);
		}
	}
}
