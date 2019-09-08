package com.accp.ajax.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.ajax.biz.StaffBiz;
import com.alibaba.fastjson.JSON;
/**
 * 
* <p>Title: StaffAction</p>  
* <p>Description:servlet </p>  
* @author Apple 

* @date 2019年4月4日
 */
public class StaffAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		StaffBiz sb = new StaffBiz();
		if ("sel".equals(method)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			String json = JSON.toJSONString(sb.SelectSome(id));
			//线程休眠
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(json);
		}
		else {
			request.setAttribute("list",sb.SelectAll() );
			request.getRequestDispatcher("/WEB-INF/jsp/First.jsp").forward(request, response);
		}
	}

}
