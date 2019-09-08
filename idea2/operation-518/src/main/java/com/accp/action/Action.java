package com.accp.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.biz.biz;
import com.accp.pojo.Air_quality_index;
import com.accp.pojo.District;
import com.accp.util.CgLibTransProxyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Servlet implementation class Action
 */
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private biz biz = CgLibTransProxyUtil.getTransProxyObject(biz.class);
    private PageInfo<Air_quality_index> info;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Action() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String usr = request.getParameter("usr");
		if("".equals(usr) || usr ==null) {
			finds(request, response);
			return;
		}
		try {
			Method method = this.getClass().getDeclaredMethod(usr, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//首页
	protected void finds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Air_quality_index> list = biz.finds();
		biz biz1 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		List<District> listd = biz1.findDiss();
		request.setAttribute("listd", listd);
		request.setAttribute("list",list);
		request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);
	}
	//进入添加页面
	protected void addjsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<District> listdis = biz.findDiss();
		request.setAttribute("listd", listdis);
		request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
	}
	//分页
//	protected void likeCaoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String cao = request.getParameter("cao");//判断什么操作
//		if ("prev".equals(cao)) { // 上一页
//			if (info.isHasPreviousPage()) {
//				PageHelper.startPage(info.getPrePage(), 2);
//				info = new PageInfo<Air_quality_index>();
//			}else {
//				System.out.println("没有上一页----------------------------------------------------------------");
//			}
//		} else if ("next".equals(cao)) { // 下一页
//			if (guanli.isHasNextPage()) {
//				PageHelper.startPage(guanli.getNextPage(), 2);
//				guanli = new PageInfo<House>(biz.likeHouses(vo));
//			}else {
//				System.out.println("没有下一页---------------------------------------------------------------");
//			}
//		}
//		
//		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
//	}
}
