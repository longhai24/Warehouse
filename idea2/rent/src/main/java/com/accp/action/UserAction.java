package com.accp.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;

import com.accp.biz.UserBiz;
import com.accp.pojo.District;
import com.accp.pojo.House;
import com.accp.pojo.HouseType;
import com.accp.pojo.Province;
import com.accp.pojo.Street;
import com.accp.pojo.user;
import com.accp.util.CgLibTransProxyUtil;
import com.accp.util.feupdate;
import com.accp.vo.HouseFabuVo;
import com.accp.vo.LikeHouseVo;
import com.accp.vo.PlacevO;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Servlet implementation class UserAction
 */
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz biz = CgLibTransProxyUtil.getTransProxyObject(UserBiz.class);
	private String place = "1"; // 地址.位置(城市)
	private String sfile = ""; // 图片地址
	private PageInfo<House> guanli;
	private LikeHouseVo vo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usr = request.getParameter("usr");
		System.out.println(usr);
		if (!"finduser".equals(usr) && !"skip-regs".equals(usr) && !"addUser".equals(usr)) {
			if (request.getSession().getAttribute("user") == null) {
				// 没登陆跳login
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
				return;
			}
		}
		// 判断是否为空或者跳页面
		if (usr == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else if (usr.startsWith("skip")) { // 跳页面
			this.skip(usr, request, response);
		} else { // 操作
			try {
				Method method = this.getClass().getDeclaredMethod(usr, HttpServletRequest.class,
						HttpServletResponse.class);
				method.invoke(this, request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 跳页面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void skip(String usr, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = usr.substring(usr.indexOf("-") + 1, usr.length());
		if ("regs".equals(name)) {
			request.getRequestDispatcher("/WEB-INF/jsp/regs.jsp").forward(request, response);
		} else if ("fabu".equals(name)) {
			List<HouseType> housetypelist = biz.findHouseType();
			List<District> dis = biz.findDis(place);
			request.setAttribute("dislist", dis);
			request.setAttribute("housetypelist", housetypelist);	
			request.getRequestDispatcher("/WEB-INF/jsp/fabu.jsp").forward(request, response);
		} else if ("guanli".equals(name)) {
			HttpSession session = request.getSession();
			user u = (user) session.getAttribute("user");
			PageHelper.startPage(1, 2);
			guanli = new PageInfo<House>(biz.findHouses(u));
			List<House> list = guanli.getList();
			request.setAttribute("Houselist", list);
			request.getRequestDispatcher("/WEB-INF/jsp/guanli.jsp").forward(request, response); // 登陆成功
		}
	}

	/**
	 * 添加用户注册
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String telephone = request.getParameter("telephone");
		String username = request.getParameter("username");
		user u = new user(name, pwd, telephone, username);
		System.out.println(u);
		int i = biz.addUser(u);
		if (i > 0) {
			response.sendRedirect("user");
		}
	}

	/**
	 * 用户登陆
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void finduser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		user u = biz.findUser(name, pwd);
		if (u != null) {
			// 将自己登陆传入session
			HttpSession session = request.getSession();
			session.setAttribute("user", u);

			// 登陆成功后并查询自己的房屋跳guanli.jsp
			response.sendRedirect("user?usr=skip-guanli");
		} else {
			response.getWriter().write("<script type=\"text/javascript\">\r\n" + "	alert(\"账号或密码出错!\")\r\n"
					+ "	window.location.href='user'\r\n" + "</script>");
		}
	}

	/**
	 * fabu.jsp发布房屋信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addhouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String himg = request.getParameter("himg");
		String type_id = request.getParameter("type_id");
		String floorage = request.getParameter("floorage");
		String price = request.getParameter("price");
		String houseDate = request.getParameter("houseDate");
		String street_id = request.getParameter("street_id");
		String contact = request.getParameter("contact");
		String description = request.getParameter("description");
		HttpSession session = request.getSession();
		user u = (user) session.getAttribute("user");
		HouseFabuVo fabu = new HouseFabuVo(title, sfile, type_id, floorage, price, houseDate, street_id, contact,
				description, u);
		System.out.println(fabu);
		int i = biz.addHouse(fabu);
		if (i > 0) {
			response.getWriter().write("<script type=\"text/javascript\">\r\n" + "	alert(\"添加成功!\")\r\n"
					+ "	window.location.href='user?usr=skip-guanli'\r\n" + "</script>");
		} else {
			response.getWriter().write("程序异常");
			;
		}
		sfile = "";
	}

	/**
	 * 获取当前区的街道
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findstreed(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String did = request.getParameter("did");
		List<Street> Streetlist = biz.findStreet(did);
		response.getWriter().write(JSON.toJSONString(Streetlist));
	}

	/**
	 * 文件上传
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void sfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sfile = new feupdate().sfile(request, response);
	}

	/**
	 * 查询单个房子信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hid = request.getParameter("id");
		House hosue = biz.findHouse(hid);
		request.setAttribute("h", hosue);
		request.getRequestDispatcher("/WEB-INF/jsp/details.jsp").forward(request, response);
	}

	/**
	 * 搜索房子
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void likeHouses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String minprice = request.getParameter("minprice");
		String maxprice = request.getParameter("maxprice");
		String street = request.getParameter("street");
		String htype = request.getParameter("htype");
		String acreage = request.getParameter("acreage");
		LikeHouseVo l = new LikeHouseVo(name, minprice, maxprice, place, street, htype, acreage);
		vo = l;
		System.out.println("搜索" + l);
		PageHelper.startPage(1, 2);
		guanli = new PageInfo<House>(biz.likeHouses(vo));
		List<House> list = guanli.getList();
		List<District> dis = biz.findDis(place);
		List<HouseType> housetypelist = biz.findHouseType();
		request.setAttribute("housetypelist", housetypelist);
		request.setAttribute("dislist", dis);
		request.setAttribute("houses", list);
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

	/**
	 * gaunli分页
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void guanlicCaoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cao = request.getParameter("cao");//判断什么操作
		HttpSession session = request.getSession();
		user u = (user) session.getAttribute("user");
		if ("prev".equals(cao)) { // 上一页
			if (guanli.isHasPreviousPage()) {
				PageHelper.startPage(guanli.getPrePage(), 2);
				guanli = new PageInfo<House>(biz.findHouses(u));
			}else {
				System.out.println("没有上一页----------------------------------------------------------------");
			}
		} else if ("next".equals(cao)) { // 下一页
			if (guanli.isHasNextPage()) {
				PageHelper.startPage(guanli.getNextPage(), 2);
				guanli = new PageInfo<House>(biz.findHouses(u));
			}else {
				System.out.println("没有下一页---------------------------------------------------------------");
			}
		}
		List<House> list = guanli.getList();
		request.setAttribute("Houselist", list);
		request.getRequestDispatcher("/WEB-INF/jsp/guanli.jsp").forward(request, response); // 登陆成功
	}
	/**
	 * 搜索分页
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void likeCaoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cao = request.getParameter("cao");//判断什么操作
		if ("prev".equals(cao)) { // 上一页
			if (guanli.isHasPreviousPage()) {
				PageHelper.startPage(guanli.getPrePage(), 2);
				guanli = new PageInfo<House>(biz.likeHouses(vo));
			}else {
				System.out.println("没有上一页----------------------------------------------------------------");
			}
		} else if ("next".equals(cao)) { // 下一页
			if (guanli.isHasNextPage()) {
				PageHelper.startPage(guanli.getNextPage(), 2);
				guanli = new PageInfo<House>(biz.likeHouses(vo));
			}else {
				System.out.println("没有下一页---------------------------------------------------------------");
			}
		}
		
		List<House> list = guanli.getList();
		List<District> dis = biz.findDis(place);
		List<HouseType> housetypelist = biz.findHouseType();
		request.setAttribute("housetypelist", housetypelist);
		request.setAttribute("dislist", dis);
		request.setAttribute("houses", list);
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

	/**
	 * 删除房子
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void removeHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hid = request.getParameter("hid");
		int i = biz.removeHouse(hid);
		if (i > 0) {
			response.getWriter().write("ok");
		}
	}

	/**
	 * 修改渲染
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void xiu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hid = request.getParameter("hid");
		House hosue = biz.findHouse(hid); // 房子信息
		List<HouseType> housetypelist = biz.findHouseType();// 房子类型
		List<District> dis = biz.findDis(place); // 区
		List<Street> Streetlist = biz.findStreet(hosue.getPla().getDid());// 获取当前区的所有街道
		request.setAttribute("dislist", dis);
		request.setAttribute("housetypelist", housetypelist);
		request.setAttribute("h", hosue);
		request.setAttribute("Streetlist", Streetlist);
		System.out.println(hosue);
		request.getRequestDispatcher("/WEB-INF/jsp/xiu.jsp").forward(request, response);
	}

	/**
	 * 修改房子
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void modifyHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hid = request.getParameter("hid");
		String title = request.getParameter("title");
		String type_id = request.getParameter("type_id");
		String floorage = request.getParameter("floorage");
		String price = request.getParameter("price");
		String houseDate = request.getParameter("houseDate");
		String street_id = request.getParameter("street_id");
		String contact = request.getParameter("contact");
		String description = request.getParameter("description");
		HouseFabuVo fabu = new HouseFabuVo(title, sfile, type_id, floorage, price, houseDate, street_id, contact,description, null);
		System.out.println(fabu+hid+"\n-------------------------------------------------------------------------------------");
		int i = biz.modifyHouse(fabu, hid);
		if(i>0) {
			response.sendRedirect("user?usr=skip-guanli");
		}
	}
	/**
	 * 查询省
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findProvices(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Province> list = biz.findProvinces();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/sheng.jsp").forward(request, response);
	}
	/**
	 * 修改位置
	 * @param request
	 * @param response
	 */
	protected void fileci(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		place = request.getParameter("cid");
		response.getWriter().write("<script type=\"text/javascript\">\r\n" + 
				"	history.go(-2); location.reload(); \r\n" + 
				"</script>");
	}


}
