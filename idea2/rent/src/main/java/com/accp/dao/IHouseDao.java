package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.House;
import com.accp.pojo.HouseType;
import com.accp.pojo.user;
import com.accp.vo.HouseFabuVo;
import com.accp.vo.LikeHouseVo;

public interface IHouseDao {
	//查询自己发布的房屋
	public List<House> findHouses(@Param("u") user u);
	//查询所有房屋类型
	public List<HouseType> findHouseType();
	//发布房屋
	public int addHouse(@Param("h") HouseFabuVo h);
	//查看房子
	public House findHouse(@Param("hid") String hid);
	//搜索房子
	public List<House> likeHouses(@Param("l") LikeHouseVo l);
	//删除房子
	public int removeHouse(@Param("hid") String hid);
	//修改房子
	public int modifyHouse(@Param("h") HouseFabuVo vo , @Param("hid") String hid);
}
