package com.accp.ajax.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accp.ajax.entity.StaffEntity;

public class StaffDao extends BaseDao{
	/**
	 * 迷糊查询
	 * @return
	 */
	public ArrayList<StaffEntity> select(String na){
		ArrayList<StaffEntity> list = new ArrayList<>();
		String sql =  "select * from `staff` where `name` like ?";
		ResultSet re = super.query(sql,"%"+na+"%");
		try {
			while(re.next()) {
				 int id = re.getInt("id");
				 String name = re.getString("name");
				 String site = re.getString("site");
				 String emial =  re.getString("emial");
				 StaffEntity sta = new StaffEntity(id, name, site, emial);
				 list.add(sta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(re);
		}
		return list;
	}

	
}
