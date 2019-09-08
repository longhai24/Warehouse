package com.accp.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.Messaging.SyncScopeHelper;

import com.accp.biz.biz;
import com.accp.pojo.Air_quality_index;
import com.accp.pojo.District;
import com.accp.util.CgLibTransProxyUtil;
import com.accp.vo.vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Servlet implementation class kl
 */
public class kl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PageInfo<Air_quality_index> info;
	private String id;
	 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public kl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String usr = request.getParameter("usr");
		if (usr == null || usr == "") {
			finds(request, response);
			return;
		}
		try {
			Method method = this.getClass().getDeclaredMethod(usr, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//
	protected void finds(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		biz biz = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		id = null;
		PageHelper.startPage(1, 2);
		info = new PageInfo<Air_quality_index>(biz.finds());
		List<Air_quality_index> list = info.getList();
		biz biz1 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		List<District> listdis = biz1.findDiss();
		request.setAttribute("listd", listdis);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);

	}

	// 进入添加页面
	protected void addjsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		biz biz1 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		List<District> listdis = biz1.findDiss();
		request.setAttribute("listd", listdis);
		request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
	}

	// 添加
	protected void addair(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String time = request.getParameter("time");
		String pm10 = request.getParameter("pm10");
		String pm25 = request.getParameter("pm25");
		String zhan = request.getParameter("zhan");
		vo v = new vo(id, time, pm10, pm25, zhan);
		biz biz1 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		int i = biz1.add(v);
		if(i>0) {
			response.sendRedirect("kl");
//			response.getWriter().write("13");
		}
	}
	protected void ddfd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		id = request.getParameter("id");
		if(id !=null) {
			response.getWriter().write("ok");
		}
	}
	protected void like(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		biz biz = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		PageHelper.startPage(1, 2);
		info = new PageInfo<Air_quality_index>(biz.like(id));
		List<Air_quality_index> list =info.getList() ;
		biz biz1 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		List<District> listdis = biz1.findDiss();
		request.setAttribute("listd", listdis);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);
	}
	protected void likeCaoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		biz biz = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		String cao = request.getParameter("cao");//判断什么操作
		if ("prev".equals(cao)) { // 上一页
			if (info.isHasPreviousPage()) {
				PageHelper.startPage(info.getPrePage(), 2);
				if(id == null) {
					info = new PageInfo<Air_quality_index>(biz.finds());
				}else {
					info = new PageInfo<Air_quality_index>(biz.like(id));
				}
			}else {
				System.out.println("没有上一页----------------------------------------------------------------");
			}
		} else if ("next".equals(cao)) { // 下一页
			if (info.isHasNextPage()) {
				PageHelper.startPage(info.getNextPage(), 2);
				if(id == null) {
					info = new PageInfo<Air_quality_index>(biz.finds());
				}else {
					info = new PageInfo<Air_quality_index>(biz.like(id));
				}
			}else {
				System.out.println("没有下一页---------------------------------------------------------------");
			}
		}
		List<Air_quality_index> list =info.getList() ;
		biz biz1 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		List<District> listdis = biz1.findDiss();
		request.setAttribute("listd", listdis);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);
	}
	protected void skipxiu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		biz biz1 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		Air_quality_index a=  biz1.a(id);
		biz biz0 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		List<District> listdis = biz0.findDiss();
		request.setAttribute("a", a);
		request.setAttribute("listd", listdis);
		request.getRequestDispatcher("/WEB-INF/jsp/xiu.jsp").forward(request, response);
	}
	protected void uio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String time = request.getParameter("time");
		String pm10 = request.getParameter("pm10");
		String pm25 = request.getParameter("pm25");
		String zhan = request.getParameter("zhan");
		String aid = request.getParameter("aid");
		vo v = new vo(id, time, pm10, pm25, zhan);
		biz biz0 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		int i = biz0.adduio(v, aid);
		if(i>0) {
			response.sendRedirect("kl");
		}
	}
	protected void dad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		biz biz0 = CgLibTransProxyUtil.getTransProxyObject(biz.class);
		int i = biz0.adddelk(id);
		if(i>0) {
			response.sendRedirect("kl");
		}
	}
}
