package com.accp.reflection.dao;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accp.reflection.entity.Member;

public class CommonDao extends BaseDao {
	
	public <T>  List<T> queryAll(Class<T> cls) {
		ResultSet rs = null;
		List<T> data;
		try {
			rs = super.query("select * from "+cls.getSimpleName());
			data = new ArrayList<T>();
			while (rs.next()) {
				Object obj=cls.newInstance();//无参
				//循环给属性赋值
				for(Field f:cls.getDeclaredFields()) {
					f.setAccessible(true);
					//通过属性名获得列值
					f.set(obj, rs.getObject(f.getName()));
				}
				data.add((T) obj);
			}
			return data;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				super.release(rs);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
}
