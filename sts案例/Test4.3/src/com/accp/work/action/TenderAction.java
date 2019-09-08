package com.accp.work.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.work.biz.TenderBiz;


/**
 * 
* <p>Title: TenderAction</p>  
* <p>Description:访问 </p>  
* @author Apple 

* @date 2019年4月3日
 */
public class TenderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TenderAction() {
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
		TenderBiz tb = new TenderBiz();
		if ("tofind".equals(method)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			request.setAttribute("sum", tb.get(id));
			request.getRequestDispatcher("/WEB-INF/jsp/New.jsp").forward(request, response);
		}
		else if("todel".equals(method)) {
			String id = request.getParameter("id");
			tb.delete(id);
			
			response.getWriter().println("<script>alert('删除成功');window.location.href='TenderAction'</script>");
			
		}
		else {
			request.setAttribute("list",tb.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/query.jsp").forward(request,response );
		}
	}

}
