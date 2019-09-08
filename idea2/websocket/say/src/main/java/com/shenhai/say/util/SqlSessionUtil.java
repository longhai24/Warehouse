package com.shenhai.say.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	private static SqlSessionFactory ssf;
	private static final String config="config.xml";
	static {
		try {
			ssf=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(config));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LoggerUtil.error("工厂创建错误",e);
			throw new RuntimeException("工厂创建错误",e);
		}
	}
	//与线程id关联的sqlsession集合
	private static ThreadLocal<SqlSession> ssLocal=new ThreadLocal<SqlSession>();
	//创建sqlsession对象
	public static SqlSession get() {
		try {
			SqlSession ss=ssLocal.get();
			if(ss==null) {
				ss=ssf.openSession();
				ssLocal.set(ss);
			}
			return ss;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.error("sqlsession创建失败",e);
			throw new RuntimeException("sqlsession创建失败",e);
		}
	}
	//关闭销毁sqlsession
	public static void close() {
		try {
			if(ssLocal.get()!=null) {
				ssLocal.get().close();
				ssLocal.set(null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.error("sqlsession销毁失败",e);
			throw new RuntimeException("sqlsession销毁失败",e);
		}
	}
	
	//提交事务
	public static void commit() {
		try {
			SqlSession ss=ssLocal.get();
			if(ss!=null) {
				ss.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.error("事务提交失败",e);
			throw new RuntimeException("事务提交失败",e);
		}
	}
	//回滚事务
	public static void rollback() {
		try {
			SqlSession ss=ssLocal.get();
			if(ss!=null) {
				ss.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.error("事务回滚失败",e);
			throw new RuntimeException("事务回滚失败",e);
		}
	}

}
