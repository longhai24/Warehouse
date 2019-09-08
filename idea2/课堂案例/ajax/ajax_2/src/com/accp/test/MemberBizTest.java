package com.accp.test;

import java.util.List;

import com.accp.biz.MemberBiz;
import com.accp.entity.Member;
import com.alibaba.fastjson.JSON;

public class MemberBizTest {

	public static void main(String[] args) {
		MemberBiz memberBiz=new MemberBiz();
//		List<Member> data=memberBiz.findMemberList();
		//序列化集合
//		String jsonStr=JSON.toJSONString(data) ;
		//序列化对象
		//jsonStr=JSON.toJSONStringWithDateFormat(data.get(0),"yyyy-MM-dd");
		//String jsonStr="{\"userId\":10,\"userName\":\"admin123\",\"userPwd\":\"666\"}";
		//反序列化对象
		//Member temp=JSON.parseObject(jsonStr, Member.class);
		//反序列化集合
		String jsonStr="[{\"userId\":1,\"userName\":\"admin\",\"userPwd\":\"666\"},{\"userId\":2,\"userName\":\"sa\",\"userPwd\":\"456\"},{\"userId\":4,\"userName\":\"test\",\"userPwd\":\"777\"},{\"userId\":5,\"userName\":\"sasa\",\"userPwd\":\"123\"},{\"userId\":6,\"userName\":\"admin123\",\"userPwd\":\"666\"}]";
		List<Member> data=JSON.parseArray(jsonStr, Member.class);
		
	}

}
