package com.accp.one.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.one.biz.StudentBiz;
import com.accp.one.entity.StudentEntity;

/**
 * Servlet implementation class StudentAction
 */
public class StudentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAction() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取做什么事情
		String usr = request.getParameter("usr");
		StudentBiz stu = new StudentBiz();
		//做排序
		if("sort".equals(usr)) {
			//判断做升序还是降序
			String sort = request.getParameter("sort");
			System.out.println(sort+"123");
			ArrayList<StudentEntity> list = stu.up(sort);
			//在request作=作用域存储list学生集合
			request.setAttribute("studentlist", list);
			request.getRequestDispatcher("/WEB-INF/jsp/Studnet.jsp").forward(request, response);
		//显示数据
		}else {
			//获取list学生集合
			ArrayList<StudentEntity> list = stu.select();
			//在request作=作用域存储list学生集合
			request.setAttribute("studentlist", list);
			//转发页面
			request.getRequestDispatcher("/WEB-INF/jsp/Studnet.jsp").forward(request, response);
		}
	}

}
