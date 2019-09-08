package com.accp.reflection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accp.reflection.entity.Book;

public class BookDao extends BaseDao {

	public List<Book> queryAllBook() {
		ResultSet rs = null;
		List<Book> data;
		try {
			rs = super.query("select * from book");
			data = new ArrayList<Book>();
			while (rs.next()) {
				data.add(new Book(rs.getInt("b_id"), rs.getString("b_name"), rs.getString("b_author")));
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

	public int deleteBookById(Integer id) {
		try {

			return super.update("delete from book where b_id=?", id);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				super.release(null);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
}
