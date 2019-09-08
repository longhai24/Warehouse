package com.accp.ajax.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import com.accp.ajax.biz.StaffBiz;
import com.accp.ajax.entity.StaffEntity;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class StaffAction
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//创建业务对象
		StaffBiz biz = new StaffBiz();
		//获取usr判断做什么事情
		String usr = request.getParameter("usr");
		if("select".equals(usr)) {
			String name = request.getParameter("name");
			//判断是否条件查询
			if(name == null) {
				name = "";
			}
			System.out.println(name+"name");
			ArrayList<StaffEntity> list = biz.select(name);
			if(list == null) {
				response.getWriter().write("1");
			}else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String pook = "编号:"+list.get(0).getId()+"姓名:"+list.get(0).getName()+"地址:"+list.get(0).getSite()+"Eamil:"+list.get(0).getEmial();
				String json = JSON.toJSONString(list);
				response.getWriter().write(json);
			}
			
		}else {
			String name = request.getParameter("name");
			if(name == null) {
				name = "";
			}
			System.out.println(name+"name");
			ArrayList<StaffEntity> list = biz.select(name);
			request.setAttribute("list",list);
			request.getRequestDispatcher("/WEB-INF/jsp/Staff.jsp").forward(request, response);
		}
	}

}
