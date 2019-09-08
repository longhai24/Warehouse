package com.accp.annotation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accp.annotation.entity.MemberInfo;

public class MemberDao extends BaseDao {

	public List<MemberInfo> queryAllMember() {
		ResultSet rs = null;
		List<MemberInfo> data;
		try {
			rs = super.query("select * from member");
			data = new ArrayList<MemberInfo>();
			while (rs.next()) {
				data.add(new MemberInfo(rs.getInt("id"), rs.getString("username"), rs.getString("upwd")));
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

	public int saveMember(MemberInfo member) {
		try {

			return super.update("insert into member(username,upwd) values(?,?)", member.getMemberName(),
					member.getMemberPwd());
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
