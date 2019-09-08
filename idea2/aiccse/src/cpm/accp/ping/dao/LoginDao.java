package cpm.accp.ping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sun.org.apache.regexp.internal.recompile;

import cpm.accp.ping.entity.Product;
import cpm.accp.ping.entity.Role;
import cpm.accp.ping.entity.Use;
import cpm.accp.ping.util.PwdUilt;

public class LoginDao extends BaseDao{
	PwdUilt pwdok = new PwdUilt();
	/**
	 * �û���½
	 */
	public Use login(String name ,String pwd) {
		String sql = "SELECT * FROM `use` WHERE `username` = ? AND `userpwd` = ?";
		//����
		pwd = pwdok.jiapwd(pwd);
		ResultSet re = super.query(sql,name,pwd);
		Use u = new Use();
		try {
			if(re.next()) {
				 Integer userid = re.getInt("userid"); 
				 String username = re.getString("username");
				 String userpwd = re.getString("userpwd");
				 String rid = re.getString("rid");
				 int uzing = re.getInt("uzing");
				 String ztime = re.getString("ztime");
				 Role ro  = selectRole(rid);
				 u = new Use(userid, username, userpwd, ro,uzing,ztime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			super.closeAll(re);
		}
		return u;
	}
	/**
	 * ��ѯ�û������Ľ�ɫ
	 */
	public Role selectRole(String id) {
		String sql = "SELECT * FROM `role` WHERE `rid` = ?";
		ResultSet re = super.query(sql, id);
		Role r = new Role();
		try {
			if(re.next()) {
				int rid = re.getInt("rid");
				String rname = re.getString("rname");
				r = new Role(rid, rname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			super.closeAll(re);
		}
		return r;
	}
	/**
	 * �����Ʒ
	 * @param pro
	 * @return
	 */
	public  int tddProduct(Product pro) {
		String sql = "INSERT INTO `product` (`pid`,`pname`,`ptype`,`pprice`,`pimg`,`pflag`,`description`) VALUES(?,?,?,?,?,?,?)";
		int i = super.exceuteUpdate(sql,pro.getPid(),pro.getPname(),pro.getPtype(),pro.getPprice(),pro.getPimg(),pro.getPflag(),pro.getDescription());
		try {
			super.closeAll(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * ��ѯ������Ʒ
	 * @return
	 */
	public ArrayList<Product> selectProduct(String type,String name){
		ArrayList<Product> list = new ArrayList<>();
		String sql = "select * from `product` WHERE 1=1";
		if("��Ʒ����".equals(type)) {
			sql = sql + " and `pname` like '%"+name+"%'";
		}else if("��Ʒ�̱�".equals(type)) {
			sql = sql + "  and `pflag` like '%"+name+"%'";
		}else if("��Ʒ�ͺ�".equals(type)) {
			sql = sql + " and `ptype` like '%"+name+"%'";
		}
		ResultSet  re = super.query(sql);
		try {
			while(re.next()) {
				 String	pid =re.getString("pid");
				 String pname = re.getString("pname");
				 String ptype= re.getString("ptype");
				 float pprice = re.getFloat("pprice");
				 String pimg= re.getString("pimg");
				 String pflag= re.getString("pflag");
				 String description= re.getString("description");
				 Product pro = new Product(pid, pname, ptype, pprice, pimg, pflag, description);
				 list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			super.closeAll(re);
		}
		return list;
	}
	/**
	 * ��ѯ��Ʒ
	 * @param type
	 * @param name
	 * @return
	 */
	public Product selectPro(String id){
		String sql = "SELECT * FROM `product` WHERE `pid` = ?";
		Product p = new Product();
		ResultSet  re = super.query(sql,id);
		try {
			while(re.next()) {
				 String pid =re.getString("pid");
				 String pname = re.getString("pname");
				 String ptype= re.getString("ptype");
				 float pprice = re.getFloat("pprice");
				 String pimg= re.getString("pimg");
				 String pflag= re.getString("pflag");
				 String description= re.getString("description");
				 p = new Product(pid, pname, ptype, pprice, pimg, pflag, description);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			super.closeAll(re);
		}
		return p;
	}
	/**
	 * �޸���Ʒ��Ϣ
	 * @param pro
	 * @return
	 */
	public int updateProduct(Product pro){
		String sql = "UPDATE `product` SET `pid` = ? ,`pname` = ?,`ptype` = ?,`pprice` = ?,`pimg` = ?,`pflag`=?,`description`=? WHERE `pid` = ?";
		int i = super.exceuteUpdate(sql,pro.getPid(),pro.getPname(),pro.getPtype(),pro.getPprice(),pro.getPimg(),pro.getPflag(),pro.getDescription(),pro.getPid());
//		System.out.println(sql+"sql���"+pro.getPid()+pro.getPname()+pro.getPtype()+pro.getPprice()+pro.getPimg()+pro.getPflag()+pro.getDescription()+pro.getPid());
		try {
			super.closeAll(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return i;
	}
	/**
	 * ɾ����Ʒ
	 * @param pid
	 * @return
	 */
	public int deleteProduct(String pid) {
		String sql = "delete from product where `pid` = ?";
		int i = super.exceuteUpdate(sql,pid);
		try {
			super.closeAll(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return i;
		
	}
	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	public ArrayList<Role> selectRole(){
		ArrayList<Role> list = new ArrayList<>();
		String sql = "select * from `role`";
		ResultSet re = super.query(sql);
		try {
			while(re.next()) {
				 Integer rid = re.getInt("rid");
				 String rname = re.getString("rname");
				 Role r = new Role(rid, rname);
				 list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			super.closeAll(re);
		}
		return list;
	}
	/**
	 * �����û�
	 * @param u
	 * @return
	 */
	public int intoRole(Use u) {
		//����
		String ok = pwdok.jiapwd(u.getUserpwd());
		u.setUserpwd(ok);
		String sql = "INSERT INTO `use` (`username`,`userpwd`,`rid`)VALUES(?,?,?)";
		int i = super.exceuteUpdate(sql,u.getUsername(),u.getUserpwd(),u.getRid());
		try {
			super.closeAll(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return i;
	}
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public ArrayList<Use> selectUses(){
		String sql = "SELECT * FROM `use`";
		ArrayList<Use> list = new ArrayList<>();
		ResultSet re = super.query(sql);
		try {
			while(re.next()) {
				 Integer userid = re.getInt("userid"); 
				 String username = re.getString("username");
				 String userpwd = re.getString("userpwd");
				 int uzing = re.getInt("uzing");
				 String ztime = re.getString("ztime");
				 //����
				 userpwd = pwdok.jiepwd(userpwd);
				 String rid = re.getString("rid");
				 Role ro  = selectRole(rid);
				 Use u  = new Use(userid, username, userpwd, ro,uzing,ztime);
				 list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			super.closeAll(re);
		}
		return list;
	}
	/**
	 * ɾ���û�����Ա
	 * @param uid
	 */
	public void deleteRole(String uid) {
		String sql ="delete from `use` where `userid` = ?";
		try {
			super.exceuteUpdate(sql,uid);
			super.closeAll(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ѯ�û�
	 * @return
	 */
	public Use selectUse(String uid){
		String sql = "SELECT * FROM `use` where `userid` = ?";
		ArrayList<Use> list = new ArrayList<>();
		ResultSet re = super.query(sql,uid);
		Use u  = new Use();
		try {
			while(re.next()) {
				 Integer userid = re.getInt("userid"); 
				 String username = re.getString("username");
				 String userpwd = re.getString("userpwd");
				 int uzing = re.getInt("uzing");
				 String ztime = re.getString("ztime");
				 //����
				 userpwd = pwdok.jiepwd(userpwd);
				 String rid = re.getString("rid");
				 Role ro  = selectRole(rid);
				 u  = new Use(userid, username, userpwd, ro,uzing,ztime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			super.closeAll(re);
		}
		return u;
	}
	/**
	 * �޸��û�
	 * @param u
	 */
	public int updatause(Use u) {
		String ok = pwdok.jiapwd(u.getUserpwd());
		u.setUserpwd(ok);
		String sql = "UPDATE `use` SET `username` = ? ,`userpwd` = ?,`rid` = ?,`uzing` = ? WHERE `userid` = ?";
		int i = super.exceuteUpdate(sql,u.getUsername(),u.getUserpwd(),u.getRid(),u.getUzing(),u.getUserid());
			try {
				super.closeAll(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			return i;
	}
	/**
	 * �����û�
	 * @param uid
	 * @return
	 */
	public int useZing(String uid) {
		String sql = "UPDATE `use` SET `uzing` = '1' ,`ztime`=? WHERE `userid` = ?";
		//��ȡϵͳ��ǰʱ��
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		int i = super.exceuteUpdate(sql,df.format(day),uid);
		super.closeAll(null);
		return i;
	}
}
