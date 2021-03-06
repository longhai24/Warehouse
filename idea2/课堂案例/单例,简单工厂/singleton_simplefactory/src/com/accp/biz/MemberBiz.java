package com.accp.biz;

import java.util.List;

import com.accp.dao.CommonDao;
import com.accp.entity.MemberInfo;

public class MemberBiz {

	private CommonDao dao = new CommonDao();

	public List<MemberInfo> findMemberList() {
		try {
			return dao.select(MemberInfo.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			dao.close();
		}
	}

	public void addMember(MemberInfo temp) {
		try {
			dao.into(temp);
			if("sa".equals(temp.getMemberName())) {
				throw new RuntimeException("用户名重复");
			}
			dao.commit();
		} catch (Exception e) {
			dao.rollback();
			throw new RuntimeException(e);
		} finally {
			dao.close();
		}
	}

}
