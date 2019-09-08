package com.accp.test;

import com.accp.biz.MemberBiz;
import com.accp.entity.MemberInfo;

public class BizTest {

	public static void main(String[] args) {
		MemberBiz biz=new MemberBiz();
		biz.addMember(new MemberInfo("sa", "123"));
	}

}
