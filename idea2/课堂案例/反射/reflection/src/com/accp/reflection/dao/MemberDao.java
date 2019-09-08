package com.accp.reflection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accp.reflection.entity.Member;

public class MemberDao extends BaseDao {

	public List<Member> queryAllMember() {
		ResultSet rs = null;
		List<Member> data;
		try {
			rs = super.query("select * from member");
			data = new ArrayList<Member>();
			while (rs.next()) {
				data.add(new Member(rs.getInt("id"), rs.getString("username"), rs.getString("upwd")));
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

	public int deleteMemberById(Integer id) {
		try {

			return super.update("delete from member where id=?", id);
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
