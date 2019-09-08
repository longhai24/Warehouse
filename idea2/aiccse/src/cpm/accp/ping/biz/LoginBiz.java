package cpm.accp.ping.biz;

import java.util.ArrayList;

import cpm.accp.ping.dao.LoginDao;
import cpm.accp.ping.entity.Product;
import cpm.accp.ping.entity.Role;
import cpm.accp.ping.entity.Use;

public class LoginBiz {
	LoginDao dao = new LoginDao();
	/**
	 * 用户登陆
	 */
	public Use login(String name ,String pwd) {
		return dao.login(name, pwd);
	}
	/**
	 * 添加商品
	 * @param pro
	 * @return
	 */
	public  void tddProduct(Product pro) {
		 int i =  dao.tddProduct(pro);
		 if(i == 0) {
			 throw new RuntimeException("商品增加失败");
		 }
	}
	/**
	 * 查询所有商品
	 * @return
	 */
	public ArrayList<Product> selectProduct(String type,String name){
		return dao.selectProduct(type,name);
	}
	/**
	 * 修改商品信息
	 * @param pro
	 * @return
	 */
	public void updateProduct(Product pro){
		int i = dao.updateProduct(pro);
		if(i == 0) {
			throw new RuntimeException("修改商品信息失败");
		}
	}
	/**
	 * 删除商品
	 * @param pid
	 * @return
	 */
	public void deleteProduct(String pid) {
		int  i = dao.deleteProduct(pid);
		if(i == 0) {
			throw new RuntimeException("删除失败");
		}
	}
	/**
	 * 查询所有角色
	 * @return
	 */
	public ArrayList<Role> selectRole(){
		return dao.selectRole();
	}
	/**
	 * 查询用户所属的角色
	 */
	public Role selectRole(String id) {
		return dao.selectRole(id);
	}
	/**
	 * 新增用户
	 * @param u
	 * @return
	 */
	public void intoRole(Use u) {
		int i =  dao.intoRole(u);
		 if(i == 0) {
			 throw new RuntimeException("商品增加失败");
		 }
	}
	/**
	 * 查询所有用户
	 * @return
	 */
	public ArrayList<Use> selectUses(){
		return dao.selectUses();
	}
	/**
	 * 删除用户管理员
	 * @param uid
	 */
	public void deleteRole(String uid) {
		dao.deleteRole(uid);
	}
	/**
	 * 查询用户
	 * @return
	 */
	public Use selectUse(String uid){
		return dao.selectUse(uid);
	}
	/**
	 * 修改用户
	 * @param u
	 */
	public void updatause(Use u) {
		int i = dao.updatause(u);
		if(i == 0) {
			throw new RuntimeException("修改失败");
		}
	}
	/**
	 * 查询商品
	 * @param type
	 * @param name
	 * @return
	 */
	public Product selectPro(String id){
		return dao.selectPro(id);
	}
	/**
	 * 冻结用户
	 * @param uid
	 * @return
	 */
	public int useZing(String uid) {
		int i = dao.useZing(uid);
		if(i <=0 ) {
			throw new RuntimeException("操作失败");
		}
		return i;
	}
}
