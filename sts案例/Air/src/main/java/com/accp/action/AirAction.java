package com.accp.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.biz.AirBiz;
import com.accp.dao.IAirDao;
import com.accp.pojo.Air_quality_index;
import com.accp.pojo.District;
import com.accp.util.CgLibTransProxyUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class AirAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AirBiz abiz =CgLibTransProxyUtil.getTransProxyObject(AirBiz.class);
	Integer upPage = 1;// 起始页数
	Integer dowmPage = 2;// 要看那一页
	PageInfo<Air_quality_index> php;
	Integer sid ;
	String aaid; 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AirAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			String method = request.getParameter("method");
			Method mm = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			Object returnVal = mm.invoke(this, request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		php = abiz.SelAll(upPage, dowmPage);
		List<Air_quality_index> hou1 = php.getList();
		request.setAttribute("show", hou1);
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	public void DownPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (php.isHasNextPage()) {
			Integer last = php.getNextPage();
			php = abiz.SelAll(last, dowmPage);
			response.getWriter().println(JSON.toJSONString(php.getList()));
		}	
	}
	public void UpPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (php.isHasPreviousPage()) {
			Integer last = php.getPrePage();
			php = abiz.SelAll(last, dowmPage);
			response.getWriter().println(JSON.toJSONString(php.getList()));
		}
	}
	
	public void FirPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer fir = php.getFirstPage();
		php = abiz.SelAll(fir, dowmPage);
		response.getWriter().println(JSON.toJSONString(php.getList()));
	}
	
	public void LasPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer las = php.getLastPage();
		php = abiz.SelAll(las, dowmPage);
		response.getWriter().println(JSON.toJSONString(php.getList()));
	}
	public void toadd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer district =Integer.valueOf(request.getParameter("district"));
		Integer pm10 = Integer.valueOf(request.getParameter("pm10"));
		Integer pm25 = Integer.valueOf(request.getParameter("pm25"));
		String address = request.getParameter("address");
		String date = request.getParameter("date");
		Air_quality_index air1 = new Air_quality_index();
		air1.setDistrict_id(district);
		air1.setMonitor_time(date);
		air1.setPm10(pm10);
		air1.setPm2_5(pm25);
		air1.setMonitoring_station(address);
		abiz.addAir(air1);
		response.sendRedirect("AirAction?method=tologin");
	}
	
	public void tosome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sid= Integer.valueOf( request.getParameter("sid"));
		request.setAttribute("show", abiz.SelSome(sid));
		request.getRequestDispatcher("/WEB-INF/jsp/some.jsp").forward(request, response);
	}
	public void removeAir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer a =  abiz.removeAir(sid);
		if (a!=0) {
			response.sendRedirect("http://localhost:8080/Air/AirAction?method=tologin");
		}
	}
	public void Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer district =Integer.valueOf(request.getParameter("district"));
		Integer pm10 = Integer.valueOf(request.getParameter("pm10"));
		Integer pm25 = Integer.valueOf(request.getParameter("pm25"));
		String address = request.getParameter("address");
		String date = request.getParameter("date");
		Air_quality_index air1 = new Air_quality_index();
		air1.setDistrict_id(district);
		air1.setMonitor_time(date);
		air1.setPm10(pm10);
		air1.setPm2_5(pm25);
		air1.setId(sid);
		air1.setMonitoring_station(address);
		abiz.modifyAir(air1);
	}
	public void sel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		aaid=	request.getParameter("word");
		php = abiz.SelAlld(upPage, dowmPage, aaid);
		List<Air_quality_index> hou1 = php.getList();
		request.setAttribute("show", hou1);
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);		
		
	}
//	public void aaa(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		AirBiz biz = CgLibTransProxyUtil.getTransProxyObject(AirBiz.class);
//		String cao = request.getParameter("cao");//判断什么操作
//		if ("prev".equals(cao)) { // 上一页
//			if (php.isHasPreviousPage()) {
//				PageHelper.startPage(php.getPrePage(), 2);
//				if(aaid == null) {
//					php = new PageInfo<Air_quality_index>(biz.SelAll1(aaid));
//				}else {
//					php = new PageInfo<Air_quality_index>(biz.SelAll1(aaid));
//				}
//			}else {
//				System.out.println("没有上一页----------------------------------------------------------------");
//			}
//		} else if ("next".equals(cao)) { // 下一页
//			if (php.isHasNextPage()) {
//				PageHelper.startPage(php.getNextPage(), 2);
//				if(aaid == null) {
//					php = new PageInfo<Air_quality_index>(biz.finds());
//				}else {
//					php = new PageInfo<Air_quality_index>(biz.like(id));
//				}
//			}else {
//				System.out.println("没有下一页---------------------------------------------------------------");
//			}
//		}
//		List<Air_quality_index> list =php.getList() ;
//		List<District> listdis = abiz.findDiss();
//		request.setAttribute("listd", listdis);
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);
//	
//	}
}
