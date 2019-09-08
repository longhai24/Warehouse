package com.accp.ajax2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accp.ajax.action.StaffAction;
import com.accp.ajax2.entity.StaffEntity;
import com.accp.ajax2.entity.SectionEntity;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import sun.swing.SwingUtilities2.Section;

public class SectionDao extends BaseDao{
	/**
	 * 查询所有部门
	 * @return
	 */
	public ArrayList<SectionEntity> selectCtion(){
		String sql = "SELECT * FROM `course_3_section`";
		ArrayList<SectionEntity> list = new ArrayList<>();
		ResultSet re = super.query(sql);
		try {
			while(re.next()) {
				 Integer id = re.getInt("id");
				 String name = re.getString("name");
				 SectionEntity sec = new SectionEntity(id, name);
				 list.add(sec);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(re);
		}
		return list;
	}
	/**
	 * 根据部门id查询该部门的职员
	 * 
	 */
	public ArrayList<StaffEntity> selectStaff(String id){
		String sql =  "SELECT * FROM `course_3_staff` WHERE `course_3_sectionid` = ?";
		ResultSet re = super.query(sql,id);
		ArrayList<StaffEntity> list = new ArrayList<>();
		try {
			while(re.next()) {
				Integer id1 = re.getInt("id");
				String name = re.getString("name");
				StaffEntity s = new StaffEntity(id1, name);
				list.add(s);
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
