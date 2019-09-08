package com.accp.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.dao.IAirDao;
import com.accp.pojo.Air_quality_index;
import com.accp.util.SqlSessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class AirBiz {

	//查询所有
	public PageInfo<Air_quality_index> SelAll(Integer pageNum, Integer pageSize) {
		IAirDao dao = SqlSessionUtil.getSession().getMapper(IAirDao.class);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<Air_quality_index> pageInfo = new PageInfo<Air_quality_index>(dao.SelAll());
		return pageInfo;
	}
	//新增
	public Integer addAir(Air_quality_index a) {
		IAirDao dao = SqlSessionUtil.getSession().getMapper(IAirDao.class);
		return dao.addAir(a);
	}
	//查询单个
	public Air_quality_index SelSome(Integer sid) {
		IAirDao dao = SqlSessionUtil.getSession().getMapper(IAirDao.class);
		return dao.SelSome(sid);
	}
	
	public Integer removeAir (Integer did) {
		IAirDao dao = SqlSessionUtil.getSession().getMapper(IAirDao.class);
		return dao.removeAir(did);
	}
	
	public Integer  modifyAir (Air_quality_index did) {
		IAirDao dao = SqlSessionUtil.getSession().getMapper(IAirDao.class);
		return dao.modifyAir(did);
	}
	public PageInfo<Air_quality_index> SelAlld(Integer pageNum, Integer pageSize,String id) {
		IAirDao dao = SqlSessionUtil.getSession().getMapper(IAirDao.class);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<Air_quality_index> pageInfo = new PageInfo<Air_quality_index>(dao.SelAA(id));
		return pageInfo;
	}
}
