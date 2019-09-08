package com.accp.work1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.work1.biz.StuBiz;
import com.accp.work1.util.MyComparator;

/**
 * 
* <p>Title: StuAction</p>  
* <p>Description:Servlet </p>  
* @author Apple 

* @date 2019Äê4ÔÂ2ÈÕ
 */
public class StuAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StuBiz sb = new StuBiz();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String method = request.getParameter("method");
		if ("Fsort".equals(method)) {
			String tname = request.getParameter("tname");
			request.setAttribute("LIST", sb.NselectAllList(tname));
			request.getRequestDispatcher("/WEB-INF/jsp/stu.jsp").forward(request, response);
		}
		else if("Nsort".equals(method)){
			String tname = request.getParameter("tname");
			request.setAttribute("LIST", sb.NselectAllList(tname));
			request.getRequestDispatcher("/WEB-INF/jsp/stu.jsp").forward(request, response);
		}
		else {
			request.setAttribute("LIST",sb.selectAllList());
			request.getRequestDispatcher("/WEB-INF/jsp/stu.jsp").forward(request, response);
		}
	}

}
