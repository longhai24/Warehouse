package com.accp.t6.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.t6.biz.PersonBiz;
import com.accp.t6.util.CgLibTransProxyUtil;

public class PersonAction extends HttpServlet {
	
	private PersonBiz biz=CgLibTransProxyUtil.getTransProxyObject(PersonBiz.class);//利用代理模式
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
