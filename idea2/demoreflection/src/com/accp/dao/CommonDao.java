package com.accp.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.accp.dao.BaseDao;

public class CommonDao extends BaseDao {
	/**
	 * 查询所有
	 * @param cls
	 * @return
	 */
	public <T> List<T> select(Class<T> cls) {
		String tableName = null;
		if (cls.isAnnotationPresent(Table.class)) {
			tableName = cls.getDeclaredAnnotation(Table.class).value();
		}
		String sql = "select * from " + tableName;
		ResultSet re = super.query(sql);
		System.out.println(sql+"sql语句");
		List<T> list = new ArrayList<>();
		try {
			while(re.next()) {
				Object obj = cls.newInstance();
				for (Field f : cls.getDeclaredFields()) {//获取所有属性
					f.setAccessible(true);
					if(f.isAnnotationPresent(Column.class)) {
						Column c = (Column)f.getDeclaredAnnotation(Column.class);
						f.set(obj,re.getObject(c.name()));
					}
				}
				list.add((T) obj);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			super.closeAll(re);
		}
		return list;
	}

	/**
	 * 根据主键id删除表实体
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public <T> int delete(Object obj) throws Exception, IllegalArgumentException, IllegalAccessException {
		String tableName = null;
		int i = 0;
		Class cls = obj.getClass();
		if (cls.isAnnotationPresent(Table.class)) {
			tableName = ((Table) cls.getDeclaredAnnotation(Table.class)).value();
		}
		for (Field f : cls.getDeclaredFields()) { // 获取所有字段
			for (Annotation a : f.getDeclaredAnnotations()) { //获取该字段所有元注解
				f.setAccessible(true); //打开属性开关
				Column c = (Column)a; //创建一个元注解对象
				if(c.isPrimaryKey()) { //判断该f(字段)元注解是否为主键
					System.out.println(a+f.getName()+f.get(obj));
					String sql = "delete from " + tableName + " where " + f.getName() + "=" +f.get(obj);
					i = super.exceuteUpdate(sql);
					super.closeAll(null);
				}
			}
		}
		return i;
	}

	/**
	 * 根据传入对象新增(主键自增)
	 * 
	 * @param obj
	 * @return
	 */
	public int into(Object obj) {
		ResultSet rs = null;
		String tblName=null; //表名
		String sql=null; // sql语句
		StringBuffer colNames=new StringBuffer(); // 列名
		StringBuffer colVals=new StringBuffer(); // 列名值
		try {
			Class cls=obj.getClass();
			//获得表名
			if(cls.isAnnotationPresent(Table.class)) {
				Table tbl=(Table) cls.getDeclaredAnnotation(Table.class);
				tblName=tbl.value(); 
			}
			//动态拼接
			for (Field f : cls.getDeclaredFields()) { //获取所有字段
				if(f.isAnnotationPresent(Column.class)) { // 判断该字段是否有Column元注解
					Column c = (Column)f.getDeclaredAnnotation(Column.class); //获取该字段元注解
					if(c.isPrimaryKey()) { //判断该字段是否为主键,主键则跳过
						continue;
					}else {
						f.setAccessible(true);
							colNames = colNames.append("`"+c.name()+"`,");
							if(f.get(obj)==null || f.get(obj) =="" || "".equals(f.get(obj))) {
								colVals = colVals.append("'"+"',");
							}else {
								colVals = colVals.append(""+"'"+f.get(obj)+"',");
							}
						}
				}
			}
			colVals = new StringBuffer(colVals.substring(0,colVals.length()-1));
			colNames = new StringBuffer(colNames.substring(0,colNames.length()-1));
			sql="insert into %s(%s) values(%s)";
			sql=String.format(sql, "`"+tblName+"`",colNames.toString(),colVals.toString());
			System.out.println(sql);
			int count=super.exceuteUpdate(sql);
			return count;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			super.closeAll(null);
		}
	}
	/**
	 * 根据主键修改
	 * @param obj
	 * @return
	 */
	public int update(Object obj) {
		ResultSet rs = null;
		String tblName=null; //表名
		String sql=null; // sql语句
		StringBuffer colNames=new StringBuffer(); // 列名
		StringBuffer whereval=new StringBuffer(); // 条件
		try {
			Class cls=obj.getClass();
			//获得表名
			if(cls.isAnnotationPresent(Table.class)) {
				Table tbl=(Table) cls.getDeclaredAnnotation(Table.class);
				tblName=tbl.value(); 
			}
			//动态拼接
			for (Field f : cls.getDeclaredFields()) {
				f.setAccessible(true);
				if(f.isAnnotationPresent(Column.class)) {
					Column c = (Column)f.getDeclaredAnnotation(Column.class);
					if(c.isPrimaryKey()) {
						whereval = whereval.append("`"+c.name()+"`='"+f.get(obj)+"'");
					}else {
							colNames = colNames.append("`"+c.name()+"`='"+f.get(obj)+"',");
					}
				}
			}
			colNames =new StringBuffer(colNames.substring(0,colNames.length()-1));
			sql="update `%s` set %s where %s";
			sql=String.format(sql, tblName,colNames.toString(),whereval.toString());
			System.out.println(sql);
			int count=super.exceuteUpdate(sql);
			return count;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			super.closeAll(null);
		}
	} 
	/**
	 * 精确查询
	 * @param obj
	 * @return
	 */
	public <T> Object AccurateQuery(Object obj) {
		ResultSet rs = null;
		String tblName=null; //表名
		String sql=null; // sql语句
		StringBuffer whereval=new StringBuffer(); // 条件
		try {
			Class cls = obj.getClass();
			if(cls.isAnnotationPresent(Table.class)) { //获取表名
				Table tbl=(Table) cls.getDeclaredAnnotation(Table.class);
				tblName=tbl.value(); 
			}
			Field[] f  = cls.getDeclaredFields(); //获取所有属性
			for (int i = 0; i < f.length; i++) {
				if(f[i].get(obj) !=null && !"".equals(f[i].get(obj))) { //判断该属性是否有值
					f[i].setAccessible(true); //开启属性开关
					if(f[i].isAnnotationPresent(Column.class)) { //判断该属性是否有元注解Column
						Column c = (Column)f[i].getDeclaredAnnotation(Column.class);
						whereval = whereval.append("and `"+c.name()+"`='"+f[i].get(obj)+"'"); //根据元注解 和 值 拼接
					}
				}
			}
			sql="select from `%s` where 1=1";
			sql=String.format(sql, tblName,whereval.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	

}
