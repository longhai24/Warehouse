package com.accp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.biz.MemberBiz;

public class TestAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private MemberBiz biz = new MemberBiz();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m = request.getParameter("m");
		// 获得方法的原型
		try {
			Method method = this.getClass().getDeclaredMethod(m, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void show1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("DATA", biz.findMemberList());
		request.getRequestDispatcher("/WEB-INF/view/show1.jsp").forward(request, response);
	}

}
