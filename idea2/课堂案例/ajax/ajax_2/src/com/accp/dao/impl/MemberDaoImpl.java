package com.accp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accp.dao.BaseDao;
import com.accp.dao.IMemberDao;
import com.accp.entity.Member;

public class MemberDaoImpl extends BaseDao implements IMemberDao {

	private List<Member> select(String sql, Object... objects) {
		ResultSet rs = null;
		List<Member> data = new ArrayList<Member>();
		try {
			rs = super.query(sql, objects);
			while (rs.next()) {
				Member temp = new Member(rs.getInt(1), rs.getString(2), rs.getString(3));
				data.add(temp);
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

	@Override
	public List<Member> queryAll() {
		return this.select("select * from tbl_member");
	}

	@Override
	public Member loadByName(String name) {
		List<Member> data = this.select("select * from tbl_member where username=?", name);
		return data.size() != 0 ? data.get(0) : null;
	}

	@Override
	public List<Member> queryByName(String userName) {
		return this.select("select * from tbl_member where username like ?", "%" + userName + "%");
	}

	@Override
	public int save(Member member) {
		try {
			return super.update("insert into tbl_member(username,userpwd) values(?,?)", member.getUserName(),
					member.getUserPwd());
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				super.release(null);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	@Override
	public int update(Member member) {
		try {
			return super.update("update tbl_member set userpwd=? where username=?", member.getUserPwd(),
					member.getUserName());
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				super.release(null);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	@Override
	public int deleteByName(String name) {
		try {
			return super.update("delete from tbl_member where username=?", name);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				super.release(null);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	@Override
	public Member loadByName(String name, String pwd) {
		List<Member> data = this.select("select * from tbl_member where username=? and userpwd=?", name, pwd);
		return data.size() != 0 ? data.get(0) : null;
	}

}
