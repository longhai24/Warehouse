package cpm.accp.ping.biz;

import java.util.ArrayList;

import cpm.accp.ping.dao.LoginDao;
import cpm.accp.ping.entity.Product;
import cpm.accp.ping.entity.Role;
import cpm.accp.ping.entity.Use;

public class LoginBiz {
	LoginDao dao = new LoginDao();
	/**
	 * �û���½
	 */
	public Use login(String name ,String pwd) {
		return dao.login(name, pwd);
	}
	/**
	 * �����Ʒ
	 * @param pro
	 * @return
	 */
	public  void tddProduct(Product pro) {
		 int i =  dao.tddProduct(pro);
		 if(i == 0) {
			 throw new RuntimeException("��Ʒ����ʧ��");
		 }
	}
	/**
	 * ��ѯ������Ʒ
	 * @return
	 */
	public ArrayList<Product> selectProduct(String type,String name){
		return dao.selectProduct(type,name);
	}
	/**
	 * �޸���Ʒ��Ϣ
	 * @param pro
	 * @return
	 */
	public void updateProduct(Product pro){
		int i = dao.updateProduct(pro);
		if(i == 0) {
			throw new RuntimeException("�޸���Ʒ��Ϣʧ��");
		}
	}
	/**
	 * ɾ����Ʒ
	 * @param pid
	 * @return
	 */
	public void deleteProduct(String pid) {
		int  i = dao.deleteProduct(pid);
		if(i == 0) {
			throw new RuntimeException("ɾ��ʧ��");
		}
	}
	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	public ArrayList<Role> selectRole(){
		return dao.selectRole();
	}
	/**
	 * ��ѯ�û������Ľ�ɫ
	 */
	public Role selectRole(String id) {
		return dao.selectRole(id);
	}
	/**
	 * �����û�
	 * @param u
	 * @return
	 */
	public void intoRole(Use u) {
		int i =  dao.intoRole(u);
		 if(i == 0) {
			 throw new RuntimeException("��Ʒ����ʧ��");
		 }
	}
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public ArrayList<Use> selectUses(){
		return dao.selectUses();
	}
	/**
	 * ɾ���û�����Ա
	 * @param uid
	 */
	public void deleteRole(String uid) {
		dao.deleteRole(uid);
	}
	/**
	 * ��ѯ�û�
	 * @return
	 */
	public Use selectUse(String uid){
		return dao.selectUse(uid);
	}
	/**
	 * �޸��û�
	 * @param u
	 */
	public void updatause(Use u) {
		int i = dao.updatause(u);
		if(i == 0) {
			throw new RuntimeException("�޸�ʧ��");
		}
	}
	/**
	 * ��ѯ��Ʒ
	 * @param type
	 * @param name
	 * @return
	 */
	public Product selectPro(String id){
		return dao.selectPro(id);
	}
	/**
	 * �����û�
	 * @param uid
	 * @return
	 */
	public int useZing(String uid) {
		int i = dao.useZing(uid);
		if(i <=0 ) {
			throw new RuntimeException("����ʧ��");
		}
		return i;
	}
}
