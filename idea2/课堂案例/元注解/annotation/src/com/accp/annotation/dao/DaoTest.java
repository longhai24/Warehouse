package com.accp.annotation.dao;

import java.sql.SQLException;
import java.util.List;

import com.accp.annotation.entity.BookInfo;
import com.accp.annotation.entity.MemberInfo;

public class DaoTest {

	/**
	 * @title: main
	 * @description: 功能描述
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) {
		CommonDao dao=new CommonDao();
		for(MemberInfo temp:dao.queryAll(MemberInfo.class)) {
			System.out.println(temp);
		}
	}

}
