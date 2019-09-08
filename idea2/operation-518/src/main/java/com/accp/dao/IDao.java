package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Air_quality_index;
import com.accp.pojo.District;
import com.accp.vo.vo;

public interface IDao {
	public List<Air_quality_index> finds();
	public List<District> findDiss();
	public int add(@Param("v") vo v);
	public List<Air_quality_index> like(@Param("id") String id);
	public Air_quality_index a(@Param("id") String id);
	public int uio(@Param("v") vo v, @Param("lp") String id);
	public int delk(@Param("id") String id);
}
