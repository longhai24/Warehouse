package com.accp.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.biz.HouseBiz;
import com.accp.pojo.Condition;
import com.accp.pojo.House;
import com.accp.pojo.HouseIo;
import com.accp.pojo.MyHouseIo;
import com.accp.pojo.User;
import com.accp.util.CgLibTransProxyUtil;
import com.accp.util.Encryption;
import com.accp.util.feupdate;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

/**
 * Servlet implementation class HouseAction
 */
public class HouseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer upPage = 1;// 起始页数
	Integer dowmPage = 2;// 要看那一页
	PageInfo<HouseIo> php;
	PageInfo<MyHouseIo> myphp;
	House hou1;
	HttpSession session ;
	
	HouseBiz hbiz = CgLibTransProxyUtil.getTransProxyObject(HouseBiz.class);// 利用代理模式
	Encryption enc = new Encryption();

	public HouseAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {
			String method = request.getParameter("method");
			if (method == null || "".equals(method)) {
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			} else {
				Method mm = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,
						HttpServletResponse.class);
				Object returnVal = mm.invoke(this, request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	// 登录
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name").trim();
		String pw = request.getParameter("password").trim();
		String pwd = enc.strongEncryption(pw);
		User u = hbiz.SelUser(uname, pwd);
		if (u != null) {
			response.getWriter().write("<script>alert('登录成功');window.location.href='HouseAction?method=showMyAllHouse'</script>");
			session = request.getSession();
			session.setAttribute("user", u);
			
		} else {
			response.getWriter().write("<script>alert('登录失败');window.location.href='HouseAction'</script>");
		}
	}

	// 跳转到注册用户
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/regs.jsp").forward(request, response);
	}

	// 添加新用户
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		String upassword = request.getParameter("password");
		String uusername = request.getParameter("username");
		Integer utelephone = Integer.valueOf(request.getParameter("telephone"));
		String pwd = enc.strongEncryption(upassword);
		User user = new User();
		user.setUser_name(uusername);
		user.setUser_password(pwd);
		user.setUser_account(uname);
		user.setUser_phone(utelephone);
		Integer i = hbiz.addUser(user);
		if (i != 0) {
			response.getWriter().write("<script>alert('注册成功');window.location.href='HouseAction'</script>");
		}
	}

	// 显示所有房屋信息
	public void showAllHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		php = hbiz.SelAllHouse(upPage, dowmPage);
		List<HouseIo> hou1 = php.getList();
		request.setAttribute("show", hou1);
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

	// 上一页
	public void showPrevious(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (php!=null) {
		if (php.isHasPreviousPage()) {
			Integer last = php.getPrePage();
			php = hbiz.SelAllHouse(last, dowmPage);
			response.getWriter().println(JSON.toJSONString(php.getList()));
		} else {
			response.getWriter().write("b");
		}
		}else {
			if (myphp.isHasPreviousPage()) {
			Integer last = myphp.getPrePage();
			User u = (User)session.getAttribute("user");
			myphp = hbiz.SelMyHouse(last, dowmPage,u.getUser_Id());
			response.getWriter().println(JSON.toJSONString(myphp.getList()));
		}
		}
	}

	// 下一页
	public void showNext(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (php!=null) {
		if (php.isHasNextPage()) {
			Integer next = php.getNextPage();
			php = hbiz.SelAllHouse(next, dowmPage);
			response.getWriter().println(JSON.toJSONString(php.getList()));
		} else {
			response.getWriter().write("a");
		}
		}else {
			if (myphp.isHasNextPage()) {
				
				User u = (User)session.getAttribute("user");
				Integer fir = myphp.getNextPage();
				myphp = hbiz.SelMyHouse(fir, dowmPage,u.getUser_Id());
				response.getWriter().println(JSON.toJSONString(myphp.getList()));
			}
		}
	}

	// 首页
	public void showFirst(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (php!=null) {
			Integer fir = php.getFirstPage();
			php = hbiz.SelAllHouse(fir, dowmPage);
			response.getWriter().println(JSON.toJSONString(php.getList()));
		}else {
			User u = (User)session.getAttribute("user");
			Integer fir = myphp.getFirstPage();
			myphp = hbiz.SelMyHouse(fir, dowmPage,u.getUser_Id());
			response.getWriter().println(JSON.toJSONString(myphp.getList()));
		}
	
	}

	// 尾页
	public void showLast(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (php!=null) {
		Integer las = php.getLastPage();
		php = hbiz.SelAllHouse(las, dowmPage);
		response.getWriter().println(JSON.toJSONString(php.getList()));
		}else {
			User u = (User)session.getAttribute("user");
			Integer las = myphp.getLastPage();
			myphp = hbiz.SelMyHouse(las, dowmPage,u.getUser_Id());
			response.getWriter().println(JSON.toJSONString(myphp.getList()));
		}
	}

	//前往首页
	public void showMyAllHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = (User)session.getAttribute("user");
		myphp = hbiz.SelMyHouse(upPage, dowmPage,u.getUser_Id() );
		request.setAttribute("myshow", myphp.getList());
		System.out.println( myphp.getList());
		request.getRequestDispatcher("/WEB-INF/jsp/guanli.jsp").forward(request, response);
	}
	
	//前往新增房屋
	public void toAddHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("typelist", hbiz.SelAllType());
		request.getRequestDispatcher("/WEB-INF/jsp/fabu.jsp").forward(request, response);
	}
	//新增房屋页面省份
	public void SelProBy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println(JSON.toJSONString(hbiz.SelAllPro()));
		
	}
	//根据省份查找市
	public void SelDowBy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer proid = Integer.valueOf(request.getParameter("proid"));
		response.getWriter().write(JSON.toJSONString(hbiz.SelDowBy(proid)));
	}
	//根据市区查找街道
	public void SelStrBy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer dowid = Integer.valueOf(request.getParameter("dowid"));
		response.getWriter().write(JSON.toJSONString(hbiz.SelStrBy(dowid)));
	}
	//新增房屋信息
	public void AddHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				feupdate f = new feupdate();
				House h =  f.sfile(request, response);
				User uid=(User)session.getAttribute("user");
				h.setUser_id(uid.getUser_Id());
				hbiz.addMyHouse(h);
				response.sendRedirect("http://localhost:8080/House/HouseAction?method=showMyAllHouse");
			}
	public void delMyHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer dhid = Integer.valueOf(request.getParameter("dhid"));
		User uid=(User)session.getAttribute("user");
		if (hbiz.removeMyHouse(uid.getUser_Id(),dhid)!=0) {
			response.getWriter().write("删除成功");
		}else {
			response.getWriter().write("删除失败");
		}
	}
	
	//前往房屋详情
	public void todetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 Integer uid = Integer.valueOf( request.getParameter("uid"));
		 request.setAttribute("show",hbiz.SelMyHouseDetial(uid));
		 request.getRequestDispatcher("/WEB-INF/jsp/details.jsp").forward(request, response);
	}
	//查询所有房屋类型
	public void SelAllType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write(JSON.toJSONString(hbiz.SelAllType()));
		
	}
	//带条件查询房屋
	public void SelSomHouByTitle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("txt");
		String money = request.getParameter("mon");
		String pro = request.getParameter("pro");
		String dow = request.getParameter("dow");
		System.out.println(dow);
		String str = request.getParameter("str");
		String type = request.getParameter("typ");
		Condition con = new Condition();
		con.setTitle(title);
		con.setMoney(money);
		con.setType(type);
		con.setProvince_id(pro);
		con.setDowntown_id(dow);
		con.setStreet_id(str);
		php = hbiz.SelSomeHouse(upPage, dowmPage,con);
		List<HouseIo> hou1 = php.getList();
		String a = JSON.toJSONString(hou1);
		System.out.println(a);
		response.getWriter().write(a);
	}
	
	//根据房屋编号查询单个房屋信息
	public void SelHouOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer oneid = Integer.valueOf(request.getParameter("oneid"));
		hou1= hbiz.SelHouOne(oneid);
		response.getWriter().write(JSON.toJSONString(hou1));
	}
	//前往修改页面
	public void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);
	}
	//修改
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		feupdate f = new feupdate();
		House h =  f.sfile(request, response);
		System.out.println(h+"\n=============================================================================");
		h.setHouse_id(hou1.getHouse_id());
		hbiz.modifyHou(h);
		response.sendRedirect("http://localhost:8080/House/HouseAction?method=showMyAllHouse");
	}
	
}
