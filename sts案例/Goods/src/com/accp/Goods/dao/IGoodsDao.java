package com.accp.Goods.dao;

import java.util.ArrayList;

import com.accp.Goods.entity.Most1;
import com.accp.Goods.entity.Productdescription;
import com.accp.Goods.entity.Users;

public interface IGoodsDao {

	Users Login(Integer uid, String upwd);

	//添加新的用户
	int addUser(Users user);

	// 添加商品
	int addProuduct(Productdescription pro);

	// 查找所有商品
	ArrayList<Productdescription> SelectAllPro();

	//注销用户
	Integer LogoutUser(Integer lid);

	//查询被注销的账号
	ArrayList<Users> SelLogoutUser();

	// 根据商品id查找商品图片
	String SelProImg(String pid);

	// 根据商品编号修改商品内容
	int UpdatePro(Productdescription pro);

	// 根据商品编号删除对应商品
	int DeletePro(String did);

	//根据名称或商标或型号进行查询
	ArrayList<Productdescription> SelProBySome(String type, String word);

	//根据用户编号恢复被注销的用户
	int RecoverUser(Integer uid);

	//查询所有用户
	ArrayList<Most1> SelAllUser();

	//根据用户编号删除用户
	int DelUser(Integer did);

	//根据用户编号修改用户信息
	int UpdateUser(Users user);

	//根据用户编号查找对应用户
	Users SelectUserById(Integer uid);

}