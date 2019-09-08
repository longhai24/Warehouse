package com.accp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.biz.UsersBiz;
import com.accp.entity.Users;
import com.accp.util.MD5Signature;
import com.alibaba.fastjson.JSON;

public class UsersAction extends HttpServlet {

	private UsersBiz usersBiz = new UsersBiz();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if ("loginin".equals(m)) {
			this.loginin(request, response);
		} else if ("loginout".equals(m)) {
			this.loginout(request, response);
		} else if ("getMember".equals(m)) {
			this.getMember(request, response);
		} else if ("getCount".equals(m)) {
			this.getCount(request, response);
		}
	}

	private void loginin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("userName");
		String pwd = request.getParameter("userPwd");
		System.out.println("action层加密密码:"+MD5Signature.md5(pwd));
		Users users = usersBiz.getUsers(name, MD5Signature.md5(pwd));
		PrintWriter out = response.getWriter();
		if (users != null) {
			session.setAttribute("USERS", users);
			//自动累计人数
			Object val=request.getSession().getServletContext().getAttribute("COUNT");
	    	if(val!=null) {
	    		Integer count=(Integer)val;
	    		count++;
	    		request.getSession().getServletContext().setAttribute("COUNT",count);
	    	}
			out.write("yes");
		} else {
			out.write("no");
		}
		out.flush();
		out.close();
	}

	private void getMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users users = (Users) request.getSession().getAttribute("USERS");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(users));// 序列化成json字符串
		out.flush();
		out.close();
	}

	private void loginout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("USERS");
		session.invalidate();//会话销毁
		response.sendRedirect("/WebFilter/login.html");

	}

	private void getCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write(request.getSession().getServletContext().getAttribute("COUNT").toString());
		out.flush();
		out.close();
	}

}
