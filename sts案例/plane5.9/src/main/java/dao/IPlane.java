package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Plane;

public interface IPlane {

	//查询所有航班
	public List<Plane> SelAll();
	//根据日期查询所有航班
	public List<Plane> SelSomebyDate(@Param("date")String date);
	//根据日期查询所有航班
	public List<Plane> SelSomebyAddress(@Param("address")String address);
	//根据编号删除航班
	public Integer Del(@Param("did")Integer did);
	//根据编号修改航班
	public Integer Update(@Param("uplane")Plane p);
}
