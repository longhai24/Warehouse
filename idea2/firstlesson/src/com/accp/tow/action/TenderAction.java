package com.accp.tow.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.tow.biz.TenderBiz;
import com.accp.tow.entity.BidEntity;
import com.accp.tow.entity.TenderEntity;

/**
 * Servlet implementation class TenderAction
 */
public class TenderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenderAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求响应转码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//创建biz对象
		TenderBiz biz = new TenderBiz();
		//获取请求usr的值判断做什么事
		String usr = request.getParameter("usr");
		if("select".equals(usr)) {
			//获取id
			String id = request.getParameter("id");
			//获取集合
			ArrayList<BidEntity> list =biz.selectbid(id);
			//存储集合
			request.setAttribute("bidlist",list);
			//跳转
			request.getRequestDispatcher("/WEB-INF/jsp/Bid.jsp").forward(request, response);
		}else if("delete".equals(usr)){ // 删除
			String id = request.getParameter("id");
			int i = biz.delete(id);
			System.out.println(i);
			if(i>0) {
				response.getWriter().println("<script>alert(\"删除成功\" ); window.location.href='tender';</script>");
			}
		}else {
			//获取集合
			ArrayList<TenderEntity> list = biz.select();
			//存储集合
			request.setAttribute("tenderlist",list);
			//跳转
			request.getRequestDispatcher("/WEB-INF/jsp/Tender.jsp").forward(request, response);
		}
	}

}
