package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Condition;
import com.accp.pojo.Downtown;
import com.accp.pojo.House;
import com.accp.pojo.HouseIo;
import com.accp.pojo.MyHouseDetial;
import com.accp.pojo.MyHouseIo;
import com.accp.pojo.Province;
import com.accp.pojo.Street;
import com.accp.pojo.Type;
import com.accp.pojo.User;
import com.github.pagehelper.PageInfo;

public interface IHouse {
	//判断数据库是否存在对应用户名和密码
	public User SelUser(@Param("acc")String account,@Param("pwd")String password);
	
	//新增新用户
	public Integer addUser(@Param("user")User u);
	
	//查询所有房屋信息
	public List<HouseIo> SelAllHouse();
	
	//查询用户所有房屋信息
	public List<MyHouseIo> SelMyHouse(@Param("uid")Integer uid);
	
	//查询所有房屋类型
	public List<Type> SelAllType();
	
	//查询所有省份
	public List<Province> SelAllPro();
	
	//根据省份查找市区
	public List<Downtown> SelDowBy(@Param("proid")Integer proid);
	
	//根据省份查找市区
	public List<Street> SelStrBy(@Param("dowid")Integer dowid);
	
	//新增房屋信息
	public Integer addMyHouse(@Param("myhou") House hou);
	
	//删除房屋
	public Integer removeMyHouse(@Param("duid") Integer did,@Param("dhid")Integer dhid);

	//查询商品详情
	public MyHouseDetial SelMyHouseDetial(@Param("selid")Integer selid);

	//根据条件查询
	public List<HouseIo> SelSomeHouse(@Param("con")Condition con);
	
	//根据房屋编号查询单个房屋信息
	public House SelHouOne(@Param("ssid")Integer sid);
	
	//修改房屋信息
	public Integer modifyHou(@Param("myhou")House hou);
}

