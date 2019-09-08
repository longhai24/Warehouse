package com.accp.biz;

import java.util.List;

import com.accp.dao.IDao;
import com.accp.pojo.Air_quality_index;
import com.accp.pojo.District;
import com.accp.util.SqlSessionUtil;
import com.accp.vo.vo;

public class biz {
	IDao dao = SqlSessionUtil.getSession().getMapper(IDao.class);
	public List<Air_quality_index> finds(){
		 return dao.finds();
	}
	
	//查询区域
	public List<District> findDiss(){
		return dao.findDiss();
	}
	//添加
	public int add(vo v) {
		return dao.add(v);
	}
	public List<Air_quality_index> like(String id){
		return dao.like(id);
	}
	public Air_quality_index a(String id) {
		return dao.a(id);
	}
	public int adduio(vo v,String id) {
		return dao.uio(v, id);
	}
	public int adddelk(String id) {
		return dao.delk(id);
	}
}
