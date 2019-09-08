package com.accp.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.dao.IHouse;
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
import com.accp.util.SqlSessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



public class HouseBiz {

	/**
	 * 
	 * <p>Title: SelUser</p>  
	 * <p>Description: 查询用户</p>  
	 * @param account
	 * @param password
	 * @return
	 */
	public User SelUser(String account, String password) {
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.SelUser(account, password);
	}
	
	public Integer addUser(User u) {
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.addUser(u);
	}
	/**
	 * 
	 * <p>Title: SelAllHouse</p>  
	 * <p>Description:查询所有房屋 </p>  
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<HouseIo> SelAllHouse(Integer pageNum, Integer pageSize) {
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<HouseIo> pageInfo = new PageInfo<HouseIo>(dao.SelAllHouse());
		return pageInfo;
	}
	/**
	 * 
	 * <p>Title: SelMyHouse</p>  
	 * <p>Description: 查询自己发布的租房信息</p>  
	 * @param pageNum
	 * @param pageSize
	 * @param uid
	 * @return
	 */
	public PageInfo<MyHouseIo> SelMyHouse(Integer pageNum, Integer pageSize ,Integer uid){
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<MyHouseIo> pageInfo = new PageInfo<MyHouseIo>(dao.SelMyHouse( uid));
		return pageInfo;
	}
	
	/**
	 * 
	 * <p>Title: SelAllType</p>  
	 * <p>Description:查询所有房屋类型 </p>  
	 * @return
	 */
	public List<Type> SelAllType(){
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.SelAllType();
	}
	
	/**
	 * 
	 * <p>Title: SelAllPro</p>  
	 * <p>Description:查询所有省份 </p>  
	 * @return
	 */
	public List<Province> SelAllPro(){
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.SelAllPro();
	}
	
	/**
	 * 
	 * <p>Title: SelDowBy</p>  
	 * <p>Description:查询所有市区 </p>  
	 * @param proid
	 * @return
	 */
	public List<Downtown> SelDowBy(Integer proid){
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.SelDowBy(proid);
	}
	
	/**
	 * 
	 * <p>Title: SelStrBy</p>  
	 * <p>Description:根据市区查找街道 </p>  
	 * @param dowid
	 * @return
	 */
	public List<Street> SelStrBy(Integer dowid){
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.SelStrBy(dowid);
	}
	
	/**
	 * 
	 * <p>Title: addMyHouse</p>  
	 * <p>Description:新增房屋 </p>  
	 * @param hou
	 * @return
	 */
	public Integer addMyHouse( House hou) {
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.addMyHouse(hou);
	}
	
	/**
	 * 
	 * <p>Title: removeMyHouse</p>  
	 * <p>Description:删除房屋信息 </p>  
	 * @param did
	 * @param dhid
	 * @return
	 */
	public Integer removeMyHouse(Integer did,Integer dhid) {
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.removeMyHouse(did, dhid);
	}
	/**
	 * 
	 * <p>Title: SelMyHouseDetial</p>  
	 * <p>Description: 显示商品详情</p>  
	 * @param uid
	 * @return
	 */
	public MyHouseDetial SelMyHouseDetial(Integer uid) {
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.SelMyHouseDetial(uid);
	}
	/**
	 * 
	 * <p>Title: SelSomeHouse</p>  
	 * <p>Description:带参查询 </p>  
	 * @param pageNum
	 * @param pageSize
	 * @param con
	 * @return
	 */
	public PageInfo<HouseIo> SelSomeHouse(Integer pageNum, Integer pageSize ,Condition con){
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<HouseIo> pageInfo = new PageInfo<HouseIo>(dao.SelSomeHouse(con));
		return pageInfo;
	}
	/**
	 * 
	 * <p>Title: SelHouOne</p>  
	 * <p>Description:查询单独房屋信息 </p>  
	 * @param sid
	 * @return
	 */
	public House SelHouOne(Integer sid) {
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.SelHouOne(sid);
	}
	/**
	 * 
	 * <p>Title: modifyHou</p>  
	 * <p>Description:修改房屋 </p>  
	 * @param hou
	 * @return
	 */
	public Integer modifyHou(House hou) {
		System.out.println(hou);
		IHouse dao = SqlSessionUtil.getSession().getMapper(IHouse.class);
		return dao.modifyHou(hou);
	}
}
