package com.accp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accp.entity.DepEntity;
import com.accp.entity.DepstaEntity;

public class DepDao extends BaseDao{
	/**
	 * ��ѯ���в���
	 * @return
	 */
	public ArrayList<DepEntity> selectDeps(){
		String sql = "SELECT * FROM dep";
		ResultSet re =super.query(sql);
		ArrayList<DepEntity> list = new ArrayList<>();
		try {
			while(re.next()) {
				 Integer id = re.getInt("id");
				 String name = re.getString("name");
				 String add = re.getString("add");
				 DepEntity d = new DepEntity(id, name, add);
				 list.add(d);
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
	 *��ѯ����
	 * @param did
	 * @return
	 */
	public DepEntity selectDep(String did){
		String sql = "SELECT * FROM dep where id = ?";
		ResultSet re =super.query(sql,did);
		 DepEntity d = new DepEntity();
		try {
			while(re.next()) {
				 Integer id = re.getInt("id");
				 String name = re.getString("name");
				 String add = re.getString("add");
				d = new DepEntity(id, name, add);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			super.closeAll(re);
		}
		return d;
	}
	/**
	 * ���ݲ��Ų�ѯ����Ա��
	 * @return
	 */
	public ArrayList<DepstaEntity> selectSta(String id){
		String sql = "select * from `depsta` where `did` = ?";
		ResultSet re =super.query(sql,id);
		ArrayList<DepstaEntity> list = new ArrayList<>();
		try {
			while(re.next()) {
				 Integer sid = re.getInt("sid");
				 String sname = re.getString("sname");
				 String sgz = re.getString("sgz");
				 float smoney = re.getFloat("smoney");
				 String stime = re.getString("stime");
				 float sjang = re.getFloat("sjang");
				 String did = re.getString("did");
				 DepEntity dep = selectDep(did);
				 DepstaEntity sta = new DepstaEntity(sid, sname, sgz, smoney, stime, sjang, dep);
				 list.add(sta);
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
	 * ɾ��Ա��
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		String sql = "DELETE FROM `depsta` WHERE `sid` = ?";
		int i = super.exceuteUpdate(sql,id);
		return i;
	}
	/**
	 * ��ѯ��ǰ����
	 * @param z
	 * @return
	 */
	public String selectZ(String z) {
		String sql = "SELECT COUNT(*) AS l FROM `depsta` WHERE `did` = ?";
		ResultSet re = super.query(sql, z);
		try {
			re.next();
			return re.getString("l");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			super.closeAll(re);
		}
	}
}
