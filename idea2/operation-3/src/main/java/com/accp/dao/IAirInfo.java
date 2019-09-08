package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.AirInfo;

public interface IAirInfo {
	//查询所有
	public List<AirInfo> selectAll(@Param("air") AirInfo ai);
	//删除
	public int delete(@Param("air") AirInfo ai);
	//修改
	public int update(@Param("air") AirInfo a);
	//添加
	public int  addition(@Param("air") AirInfo a);
}
