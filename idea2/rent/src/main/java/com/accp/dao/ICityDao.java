package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.City;
import com.accp.pojo.District;
import com.accp.pojo.Province;
import com.accp.pojo.Street;

public interface ICityDao {
	//查询当前市的所有区
	public List<District> findCity(@Param("pid") String pid);
	//查询当前区的所有街
	public List<Street> findStreet(@Param("did") String did);
	//查询所有省
	public List<Province> findProvinces();
}
