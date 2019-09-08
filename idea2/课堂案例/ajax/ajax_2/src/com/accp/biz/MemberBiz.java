package com.accp.biz;

import java.util.List;

import com.accp.dao.IMemberDao;
import com.accp.dao.impl.MemberDaoImpl;
import com.accp.entity.Member;

public class MemberBiz {

	IMemberDao dao = new MemberDaoImpl();

	public List<Member> findMemberList() {

		return dao.queryAll();
	}

	public void addMemberInfo(Member temp) {
		if (dao.loadByName(temp.getUserName()) != null) {
			throw new RuntimeException("会员名已存在");
		}
		int count = dao.save(temp);
		if (count == 0) {
			throw new RuntimeException("会员添加失败");
		}
	}

	public List<Member> findMemberByName(String name) {
		return dao.queryByName(name);
	}

	public Member getMemberByNameAndPwd(String name, String pwd) {
		return dao.loadByName(name, pwd);
	}

	public Member getMemberByName(String name) {
		return dao.loadByName(name);
	}

	public void removeMember(String name) {
		int count = dao.deleteByName(name);
		if (count == 0) {
			throw new RuntimeException("会员移除失败");
		}
	}

	public void modifyMember(Member member) {
		int count = dao.update(member);
		if (count == 0) {
			throw new RuntimeException("会员更新失败");
		}
	}
}
