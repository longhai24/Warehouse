package com.accp.reflection.dao;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public abstract class BaseDao {
	public static String CLASS_NAME;
	public static String URL;
	public static String USER_NAME;
	public static String USER_PWD;

	private Connection conn;
	private PreparedStatement ps;

	private static Logger logger = Logger.getRootLogger();

	static {
		Properties param = new Properties();

		try {
			param.load(BaseDao.class.getResourceAsStream("db.properties"));
			URL = param.getProperty("db.url");
			CLASS_NAME = param.getProperty("db.classname");
			USER_NAME = param.getProperty("db.username");
			USER_PWD = param.getProperty("db.pwd");
		} catch (IOException ex) {
			logger.error("配置文件读取失败", ex);
		}

		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			logger.error("驱动加载失败", e);
		}

	}

	public void openConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
		}
	}

	public void release(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

	public int update(String sql, Object... params) throws SQLException {
		logger.debug("执行SQL:" + sql);
		this.openConnection();
		ps = conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		int count = ps.executeUpdate();
		return count;
	}

	public ResultSet query(String sql, Object... params) throws SQLException {
		logger.debug("执行SQL:" + sql);
		this.openConnection();
		ps = conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		ResultSet rs = ps.executeQuery();
		return rs;
	}

}
