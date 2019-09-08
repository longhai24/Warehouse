package com.accp.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.accp.one.entity.StudentEntity;

public class StudentDao extends BaseDao implements Istudent{
	/* (non-Javadoc)
	 * 所有查询
	 * @see com.accp.one.dao.Istudent#select()
	 */
	@Override
	public ArrayList<StudentEntity> select(){
		String sql = "select * from t1";
		ArrayList<StudentEntity> list = new ArrayList<>();
		ResultSet re = super.query(sql);
		try {
			while(re.next()) {
				 Integer id = re.getInt("id");
				 String name = re.getString("name");
				 String sex = re.getString("sex");
				 int age = re.getInt("age");
				 Date time = re.getDate("time");
				 StudentEntity s = new StudentEntity(id, name, sex, age, time);
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
