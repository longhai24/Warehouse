package com.accp.annotation.dao;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommonDao extends BaseDao {

	public <T> List<T> queryAll(Class<T> cls) {
		ResultSet rs = null;
		List<T> data;
		String tblName=null;
		try {
			//获得表名
			if(cls.isAnnotationPresent(Table.class)) {
				Table tbl=cls.getDeclaredAnnotation(Table.class);
				tblName=tbl.value();
			}
			rs = super.query("select * from " + tblName);
			data = new ArrayList<T>();
			while (rs.next()) {
				Object obj = cls.newInstance();// 无参
				// 循环给属性赋值
				for (Field f : cls.getDeclaredFields()) {
					f.setAccessible(true);
					// 通过属性名获得列值
					//获得属性上的列的元注解
					if(f.isAnnotationPresent(Column.class)) {
						Column c=f.getDeclaredAnnotation(Column.class);
						f.set(obj, rs.getObject(c.name()));
					}
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
	
	public int  save(Object obj) {
		ResultSet rs = null;
		String tblName=null;
		String sql=null;
		StringBuffer colNames=new StringBuffer();
		StringBuffer colVals=new StringBuffer();
		try {
			Class cls=obj.getClass();
			//获得表名
			if(cls.isAnnotationPresent(Table.class)) {
				Table tbl=(Table) cls.getDeclaredAnnotation(Table.class);
				tblName=tbl.value();
			}
			//动态拼接
			sql="insert into %s(%s) values(%s)";
			sql=String.format(sql, tblName,colNames.toString(),colVals.toString());
			int count=super.update(sql);
			return count;
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
