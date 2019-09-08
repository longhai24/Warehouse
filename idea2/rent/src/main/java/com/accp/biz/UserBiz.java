package com.accp.biz;

import java.util.List;

import com.accp.dao.ICityDao;
import com.accp.dao.IHouseDao;
import com.accp.dao.IUserDao;
import com.accp.pojo.District;
import com.accp.pojo.House;
import com.accp.pojo.HouseType;
import com.accp.pojo.Province;
import com.accp.pojo.Street;
import com.accp.pojo.user;
import com.accp.util.SqlSessionUtil;
import com.accp.vo.HouseFabuVo;
import com.accp.vo.LikeHouseVo;

public class UserBiz {
	/**
	 * 查询用户
	 * @return
	 */
	public List<user> findUsers(){
		IUserDao dao = SqlSessionUtil.getSession().getMapper(IUserDao.class);
		return dao.findUsers();
	}
	/**
	 * 注册用户
	 * @param u
	 * @return
	 */
	public int addUser(user u) {
		IUserDao dao = SqlSessionUtil.getSession().getMapper(IUserDao.class);
		return dao.addUser(u);
	}
	/**
	 * 登陆
	 * @param name
	 * @param pwd
	 * @return
	 */
	public user findUser(String name,String pwd) {
		IUserDao dao = SqlSessionUtil.getSession().getMapper(IUserDao.class);
		return dao.findUser(name, pwd);
	}
	/**
	 * 查询自己发布的房屋
	 * @param u
	 * @return
	 */
	public List<House> findHouses(user u){
		IHouseDao dao = SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.findHouses(u);
	}
	/**
	 * 查询所有房屋类型
	 * @return
	 */
	public List<HouseType> findHouseType(){
		IHouseDao dao = SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.findHouseType();
	}
	/**
	 * 查询当前城市的所有区
	 * @param pid
	 * @return
	 */
	public List<District> findDis(String pid){
		ICityDao dao = SqlSessionUtil.getSession().getMapper(ICityDao.class);
		return dao.findCity(pid);
	}
	/**
	 * 查询当前区的所有街道
	 * @param pid
	 * @return
	 */
	public List<Street> findStreet(String did){
		ICityDao dao = SqlSessionUtil.getSession().getMapper(ICityDao.class);
		return dao.findStreet(did);
	}
	/**
	 * 发布房屋
	 * @return
	 */
	public int addHouse(HouseFabuVo h) {
		IHouseDao dao = SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.addHouse(h);
	}	
	/**
	 * 查看房子
	 * @return
	 */
	public House findHouse(String hid) {
		IHouseDao dao = SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.findHouse(hid);
	}
	/**
	 * 搜索房子
	 */
	public List<House> likeHouses(LikeHouseVo l){
		IHouseDao dao = SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.likeHouses(l);
	}
	/**
	 * 删除房子
	 * @return
	 */
	public int removeHouse(String hid) {
		IHouseDao dao = SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.removeHouse(hid);
	}
	/**
	 * 修改房子
	 * @param fabu
	 * @param hid
	 * @return
	 */
	public int modifyHouse(HouseFabuVo fabu ,String hid) {
		IHouseDao dao = SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.modifyHouse(fabu, hid);
	}
	/**
	 * 查询省
	 * @return
	 */
	public List<Province> findProvinces(){
		ICityDao dao = SqlSessionUtil.getSession().getMapper(ICityDao.class);
		return dao.findProvinces();
	}
}
