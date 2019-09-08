package com.accp.Goods.biz;

import java.util.ArrayList;

import com.accp.Goods.dao.GoodsDao;
import com.accp.Goods.dao.IGoodsDao;
import com.accp.Goods.entity.Most1;
import com.accp.Goods.entity.Productdescription;
import com.accp.Goods.entity.Users;

/**
 * 
 * <p>
 * Title: GoodsBiz
 * </p>
 * <p>
 * Description:ÒµÎñÂß¼­²Ù×÷²ã
 * </p>
 * 
 * @author Apple
 * 
 * @date 2019Äê4ÔÂ10ÈÕ
 */
public class GoodsBiz {

	IGoodsDao gdao = new GoodsDao();

	
	public void LogoutUser(Integer lid) {
		if (gdao.LogoutUser(lid)==0) {
			throw new RuntimeException("×¢ÏúÊ§°Ü");
		}
	}
	public Users Login(Integer uid, String upwd) {
		return gdao.Login(uid, upwd);
	}
	 
	public void  addUser(Users user) {
		int row = gdao.addUser(user);
		if (row == 0) {
			throw new RuntimeException("Ìí¼ÓÊ§°Ü");
		}
	}
	public void addProuduct(Productdescription pro) {
		int row = gdao.addProuduct(pro);
		if (row == 0) {
			throw new RuntimeException("Ìí¼ÓÊ§°Ü");
		}
	}
	
	public void RecoverUser(Integer uid) {
		int row = gdao.RecoverUser(uid);
		if (row ==0) {
			throw new RuntimeException("»Ö¸´Ê§°Ü");
		}
	}
	public ArrayList<Users> SelLogoutUser(){
		return gdao.SelLogoutUser();
	}
	public ArrayList<Most1> SelAllUser(){
		return gdao.SelAllUser();
	}
	public ArrayList<Productdescription> SelProBySome(String type, String word)
	{
		return gdao.SelProBySome(type, word);
	}
	public String SelProImg(String pid) {
		return gdao.SelProImg(pid);
	}

	public ArrayList<Productdescription> SelectAllPro() {
		return gdao.SelectAllPro();
	}

	public void UpdatePro(Productdescription pro) {
		if (gdao.UpdatePro(pro) == 0) {
			throw new RuntimeException("ÐÞ¸ÄÊ§°Ü");
		}
	}

	public Users SelectUserById(Integer uid) {
		return gdao.SelectUserById(uid);
	}
	public void UpdateUser(Users user) {
		if (gdao.UpdateUser(user)==0) {
			throw new RuntimeException("ÐÞ¸ÄÊ§°Ü");
		}
	}
	
	public void DeletePro(String did) {
		if (gdao.DeletePro(did) == 0) {
			throw new RuntimeException("É¾³ýÊ§°Ü");
		}
	}
	public void DeleteUser(Integer did) {
		if (gdao.DelUser(did) == 0) {
			throw new RuntimeException("É¾³ýÊ§°Ü");
		}
	}
	
}
