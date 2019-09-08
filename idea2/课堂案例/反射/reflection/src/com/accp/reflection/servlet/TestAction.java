package com.accp.reflection.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m = request.getParameter("m");
//
//		if ("f1".equals(m)) {
//			this.show1(request, response);
//		} else if ("f2".equals(m)) {
//			this.show2(request, response);
//		} else if ("f3".equals(m)) {
//			this.show3(request, response);
//		}
			try {
				
				Method mm=this.getClass().getDeclaredMethod(m,HttpServletRequest.class,HttpServletResponse.class);
				Object returnVal=mm.invoke(this,request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

	private void show1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/show1.jsp").forward(request, response);
	}

	private void show2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/show2.jsp").forward(request, response);
	}

	private void show3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/show3.jsp").forward(request, response);
	}

}
