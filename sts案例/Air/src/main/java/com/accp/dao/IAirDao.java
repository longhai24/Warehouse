package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Air_quality_index;

public interface IAirDao {
	//查询所有信息
	public List<Air_quality_index> SelAll();
	
	//新增
	public Integer addAir(@Param("air")Air_quality_index a);
	
	//带参查询
	public Air_quality_index SelSome(@Param("sid")Integer sid);
	
	//待条件删除
	public Integer removeAir (@Param("did")Integer did);
	
	public Integer  modifyAir (@Param("b")Air_quality_index did);
	
	public List<Air_quality_index> SelAA(@Param("AAA")String sid);
}
