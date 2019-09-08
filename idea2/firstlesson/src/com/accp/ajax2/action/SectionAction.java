package com.accp.ajax2.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.ajax2.biz.SectionBiz;
import com.accp.ajax2.entity.SectionEntity;
import com.accp.ajax2.entity.StaffEntity;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class SectionAction
 */
public class SectionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SectionAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建biz层对象
		SectionBiz biz = new SectionBiz();
		// T设置编码
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取前台要干什么事
		String usr = request.getParameter("usr");
		if("select".equals(usr)) {
			String id = request.getParameter("id");
			ArrayList<StaffEntity> list = biz.selectStaff(id);
			String json = JSON.toJSONString(list);
			response.getWriter().write(json);
		}else {
			ArrayList<SectionEntity> list = biz.selectCtion();
			request.setAttribute("sectionlist", list);
			request.getRequestDispatcher("/WEB-INF/jsp/Section.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
