package com.accp.ajax.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.ajax.biz.TestBiz;
import com.accp.ajax.entity.Staff;
import com.alibaba.fastjson.JSON;

/**
 * 
* <p>Title: TestAction</p>  
* <p>Description: </p>  
* @author Apple 

* @date 2019Äê4ÔÂ9ÈÕ
 */
public class TestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset= utf-8");
		String method = request.getParameter("method");
		TestBiz tBiz = new TestBiz();
		if ("sel".equals(method)) {
			Integer did = Integer.valueOf(request.getParameter("did"));
			ArrayList<Staff> Slist = tBiz.SelectSta(did);
			String json = JSON.toJSONString(Slist);
			response.getWriter().write(json);
		}else {
			request.setAttribute("list",tBiz.SelectDem());
			request.getRequestDispatcher("/WEB-INF/jsp/NewFile.jsp").forward(request, response);
		}
	}

}
