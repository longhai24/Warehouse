package com.accp.reflection.test;

import java.sql.SQLException;
import java.util.List;

import com.accp.reflection.dao.CommonDao;
import com.accp.reflection.entity.Book;
import com.accp.reflection.entity.Member;

public class DaoTest {

	/**
	 * @title: main
	 * @description: 功能描述
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) {
		CommonDao dao = new CommonDao();
		for (Book temp : dao.queryAll(Book.class)) {
			System.out.println(temp);
		}
	}

}
