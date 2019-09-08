package com.accp.Goods.dao;

import java.util.ArrayList;

import com.accp.Goods.entity.Most1;
import com.accp.Goods.entity.Productdescription;
import com.accp.Goods.entity.Users;
import com.accp.Goods.util.CountDate;
import com.accp.Goods.util.Encryption;

/**
 * 
 * <p>
 * Title: GoodsDao
 * </p>
 * <p>
 * Description:�����ݿ����
 * </p>
 * 
 * @author Apple a
 * @date 2019��4��9��
 */
public class GoodsDao extends BaseDao implements IGoodsDao  {

	// �ж����ݿ��Ƿ����û��������룬��������½�ɹ�����֮��¼ʧ��
	CountDate cd = new CountDate();
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#Login(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Users Login(Integer uid, String upwd) {
		Encryption enc = new Encryption();
		String code = enc.strongEncryption(upwd);
		String sql = "SELECT * FROM `users` WHERE `userid` = ? AND `userpwd` = ? and dtype = 1";
		rs = super.Select(sql, uid, code);
		Users user = null;
		try {
			while (rs.next()) {
				Integer userid = rs.getInt("userid");
				String username = rs.getString("username");
				String userpwd = rs.getString("userpwd");
				Integer rid = rs.getInt("rid");
				user = new Users(userid, username, userpwd, rid);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			super.Close(pst, conn);
		}
		return user;
	}

	//����µ��û�
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#addUser(com.accp.Goods.entity.Users)
	 */
	@Override
	public int addUser(Users user){
		Encryption enc = new Encryption();
		String code = enc.strongEncryption(user.getUserpwd());
		String sql = "INSERT INTO `users`(`username`,`userpwd`,`rid`)VALUES(?,?,?)";
		return super.Update(sql, user.getUsername(),code,user.getRid());
		
	}
	
	// �����Ʒ
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#addProuduct(com.accp.Goods.entity.Productdescription)
	 */
	@Override
	public int addProuduct(Productdescription pro) {
		String sql = "INSERT INTO `productdescription`(`pid`,`pname`,`ptype`,`pprice`,`pimg`,`pflag`) VALUES(?,?,?,?,?,?)";
		return super.Update(sql, pro.getPid(), pro.getPname(), pro.getPtype(), pro.getPprice(), pro.getPimg(),
				pro.getPflag());
	}

	// ����������Ʒ
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#SelectAllPro()
	 */
	@Override
	public ArrayList<Productdescription> SelectAllPro() {
		ArrayList<Productdescription> plist = new ArrayList<>();
		String sql = "SELECT * FROM `productdescription`";
		rs = super.Select(sql);
		try {
			while (rs.next()) {
				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				String ptype = rs.getString("ptype");
				Float pprice = rs.getFloat("pprice");
				String pimg = rs.getString("pimg");
				String pflag = rs.getString("pflag");
				Productdescription pro = new Productdescription(pid, pname, ptype, pprice, pimg, pflag);
				plist.add(pro);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			super.Close(pst, conn);
		}
		return plist;
	}

	//ע���û�
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#LogoutUser(java.lang.Integer)
	 */
	@Override
	public Integer LogoutUser(Integer lid) {
		String sql = "UPDATE `users`SET`dtype`=0 ,dtime=? WHERE `userid`=?";
		String time  =cd.getCurrentDay();
		return super.Update(sql,time ,lid);
	}
	
	//��ѯ��ע�����˺�
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#SelLogoutUser()
	 */
	@Override
	public ArrayList<Users> SelLogoutUser(){
		
		String sql = "SELECT * FROM `users` WHERE `dtype` =0";
		rs = super.Select(sql);
		ArrayList<Users> list = new ArrayList<>();
		try {
			while (rs.next()) {
				String username = rs.getString("username");
				Integer userid = rs.getInt("userid");
				String userpwd = rs.getString("userpwd");
				Integer rid = rs.getInt("rid");
				Integer dtype = rs.getInt("dtype");
				String dtime = rs.getString("dtime");
				Users user = new Users(userid, username, userpwd, rid, dtype, dtime);
				list.add(user);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			super.Close(pst, conn);
		}
		return list;
	}
	
	// ������Ʒid������ƷͼƬ
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#SelProImg(java.lang.String)
	 */
	@Override
	public String SelProImg(String pid) {
		String sql = "SELECT `pimg` FROM `productdescription` WHERE `pid` =?";
		String img = "";
		rs = super.Select(sql, pid);
		try {
			while (rs.next()) {
				img = rs.getString("pimg");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			super.Close(pst, conn);
		}
		return img;
	}

	// ������Ʒ����޸���Ʒ����
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#UpdatePro(com.accp.Goods.entity.Productdescription)
	 */
	@Override
	public int UpdatePro(Productdescription pro) {
		String sql = "UPDATE `productdescription` SET `pname`=?,`ptype`=?,`pprice`=?,`pimg`=?,`pflag`=?WHERE `pid`=?";
		
		return super.Update(sql, pro.getPname(), pro.getPtype(), pro.getPprice(), pro.getPimg(), pro.getPflag(),
				pro.getPid());
	}

	// ������Ʒ���ɾ����Ӧ��Ʒ
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#DeletePro(java.lang.String)
	 */
	@Override
	public int DeletePro(String did) {
		String sql = "DELETE FROM `productdescription` WHERE `pid`=?";
		return super.Update(sql, did);
	}

	//�������ƻ��̱���ͺŽ��в�ѯ
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#SelProBySome(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Productdescription> SelProBySome(String type, String word) {
			ArrayList<Productdescription> list = new ArrayList<>();
			String sql ="SELECT * FROM `productdescription` WHERE ";
			if ("��Ʒ����".equals(type)) {
				sql = sql+" pname LIKE '%"+word+"%'";
			}else if ("��Ʒ�̱�".equals(type)) {
				sql = sql+" pflag LIKE '%"+word+"%'";
			}
			else if ("��Ʒ�ͺ�".equals(type)) {
				sql = sql+" ptype LIKE '%"+word+"%'";
			}
			rs = super.Select(sql);
			try {
				while (rs.next()) {
					String pid = rs.getString("pid");
					String pname = rs.getString("pname");
					String ptype = rs.getString("ptype");
					Float pprice = rs.getFloat("pprice");
					String pimg = rs.getString("pimg");
					String pflag = rs.getString("pflag");
					Productdescription pro = new Productdescription(pid, pname, ptype, pprice, pimg, pflag);
					list.add(pro);
				}
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
			finally {
				super.Close(pst, conn);
			}
			return list;
	}

	//�����û���Żָ���ע�����û�
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#RecoverUser(java.lang.Integer)
	 */
	@Override
	public int RecoverUser(Integer uid) {
		String sql = "UPDATE `users` SET `dtype` =1 , `dtime` =\"(NULL)\" WHERE `userid` = ?";
		return super.Update(sql, uid);
	}
	
	//
	
	//��ѯ�����û�
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#SelAllUser()
	 */
	@Override
	public ArrayList<Most1> SelAllUser(){
		ArrayList<Most1> list = new ArrayList<>();
		String sql ="SELECT u.`userid` AS uid,u.`username` AS uname,u.`dtype` AS utype, u.`rid` AS urid,s.`rname` AS sname  FROM `users`AS u JOIN `staff` AS s ON s.`rid`=u.`rid`";
		rs = super.Select(sql);
		try {
			while (rs.next()) {
				Integer udtype = rs.getInt("utype");
				String uname  =rs.getString("uname");
				String sname = rs.getString("sname");
				Integer uid = rs.getInt("uid");
				Integer urid = rs.getInt("urid");
				Most1 most = new Most1(uid, urid, uname, sname,udtype);
				list.add(most);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		finally {
			super.Close(pst, conn);
		}
		return list;
	}
	
	//�����û����ɾ���û�
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#DelUser(java.lang.Integer)
	 */
	@Override
	public int DelUser(Integer did) {
		String sql = "DELETE FROM `users` WHERE `userid` =?";
		return super.Update(sql, did);
	}
	
	//�����û�����޸��û���Ϣ
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#UpdateUser(com.accp.Goods.entity.Users)
	 */
	@Override
	public int UpdateUser(Users user) {
		String sql="UPDATE `users` SET `username` = ?,`userpwd`=?,`rid`=? WHERE userid=?";
		
		String pwd = new  Encryption().strongEncryption(user.getUserpwd());
		return super.Update(sql, user.getUsername(),pwd,user.getRid(),user.getUserid());
	}
	
	//�����û���Ų��Ҷ�Ӧ�û�
	/* (non-Javadoc)
	 * @see com.accp.Goods.dao.IGoodsDao#SelectUserById(java.lang.Integer)
	 */
	@Override
	public Users SelectUserById(Integer uid) {
		String sql = "SELECT * FROM `users` WHERE `userid` =?";
		Users user = new Users();
		rs = super.Select(sql, uid);
		try {
			while (rs.next()) {
				Integer userid = rs.getInt("userid");
				String username = rs.getString("username");
				String userpwd = rs.getString("userpwd");
				Integer rid = rs.getInt("rid");
				user = new Users(userid, username, userpwd, rid);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		finally {
			super.Close(pst, conn);
		}
		return user;
	}
	
}
