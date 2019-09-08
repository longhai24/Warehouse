package com.accp.t6.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {

	private static final ThreadLocal<SqlSession> sessionMap = new ThreadLocal<SqlSession>();

	private static SqlSessionFactory sf;

	private static final String CFG_PATH = "config.xml";

	static {
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		try {
			sf = sfb.build(Resources.getResourceAsStream(CFG_PATH));
		} catch (Exception e) {
			LoggerUtil.error("SqlSessionFactory构建失败", e);
		}
	}

	public static SqlSession getSession() {
		try {
			SqlSession session = sessionMap.get();
			if (session == null) {
				session = sf.openSession();
				sessionMap.set(session);
			}
			return session;
		} catch (Exception e) {
			LoggerUtil.error("SqlSession构建失败", e);
			throw new RuntimeException(e);
		}
	}

	public static void closeSession() {
		try {
			SqlSession session = sessionMap.get();
			if (session != null) {
				session.close();
				sessionMap.set(null);
			}
		} catch (Exception e) {
			LoggerUtil.error("SqlSession销毁失败", e);
			throw new RuntimeException(e);
		}
	}

	public static void commit() {
		SqlSession session = sessionMap.get();
		if (session != null) {
			session.commit();
		}
	}

	public static void rollback() {
		SqlSession session = sessionMap.get();
		if (session != null) {
			session.rollback();
		}
	}
}
