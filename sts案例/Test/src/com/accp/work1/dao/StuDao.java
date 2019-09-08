package com.accp.work1.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.accp.work1.entity.Stu;
/**
 * 
* <p>Title: StuDao</p>  
* <p>Description:学生数据访问 </p>  
* @author Apple 

* @date 2019年4月2日
 */
public class StuDao extends BaseDao implements IStuDao{
	
	
	public ArrayList<Stu> selectAllList(){
	
		String sql = "select * from stu";
		ArrayList<Stu> list = new ArrayList<>();
		rs = super.Select(sql);
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				Integer sex = rs.getInt("id");
				Date date = rs.getDate("date");
				Integer age = rs.getInt("age");
				Stu stu = new Stu(id, name, age, sex, date);
				list.add(stu);
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
}
