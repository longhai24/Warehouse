package com.tx.no1.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class no1Action
 */
public class no1Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		
		try {
			String method = request.getParameter("method");
			if (method == null || "".equals(method)) {
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			} else {
				Method mm = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,
						HttpServletResponse.class);
				Object returnVal = mm.invoke(this, request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
