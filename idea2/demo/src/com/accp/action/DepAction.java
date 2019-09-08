package com.accp.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import com.accp.biz.DepBiz;
import com.accp.entity.DepEntity;
import com.accp.entity.DepstaEntity;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class DepAction
 */
public class DepAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String lid = "";
	DepBiz biz = new DepBiz();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取usr
		String usr = request.getParameter("usr");
		if("selectdep".equals(usr)) {
			this.selectdep(request, response);
		}
		else if("selectstae".equals(usr)) {
			this.selectstae(request, response);
		}
		else if("delete".equals(usr)) {
			this.delete(request, response);
		}
		else if("selectsta".equals(usr)) {
			System.out.println("金");
			this.selectSta(request, response);
		}
		else {
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 查询所有部门
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selectdep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DepEntity> list = biz.selectDeps();
		response.getWriter().write(JSON.toJSONString(list));
	}
	/**
	 * 根据部门查询所有员工
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selectSta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DepstaEntity> list = biz.selectSta(lid);
		System.out.println("进来了");
		response.getWriter().write(JSON.toJSONString(list));
	}
	/**
	 * 根据部门查询所有员工
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selectstae(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String did = request.getParameter("did");
		lid = did;
		response.getWriter().write("ok");
	}
	/**
	 * 删除员工
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("did");
		String z = request.getParameter("z");
		int i = biz.delete(id);
		if(i > 0) {
			System.out.println("删除成功");
			response.getWriter().write(biz.selectZ(z));
		}
	}

}
