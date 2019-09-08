package com.tx.Bank.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.tx.Bank.biz.BankBiz;
import com.tx.Bank.pojo.Account;
import com.tx.Bank.pojo.Transaction_record;
import com.tx.Bank.util.SpringBeanUtil;

public class BankAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankBiz bbiz = SpringBeanUtil.getBeanByName("biz");
	Account user;
	Integer upPage = 1;// 起始页数
	Integer dowmPage = 2;// 要看那一页
	PageInfo<Transaction_record> ptr;
	String date1;
	String date2;

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
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

	/**
	 * 
	 * <p>
	 * Title: login
	 * </p>
	 * <p>
	 * Description: 登录方法
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cardno = request.getParameter("cardno");
		String password = request.getParameter("password");
		user = bbiz.SelUser(cardno, password);
		if (user != null) {
			response.getWriter().write("<script>alert('登录成功')</script>");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);
		} else {
			response.getWriter().write("<script>alert('登录失败')</script>");
		}
	}

	/**
	 * 
	 * <p>
	 * Title: transfer
	 * </p>
	 * <p>
	 * Description:转账方法
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void transfer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cardNum = request.getParameter("Intoaccount");
		Integer money = Integer.valueOf(request.getParameter("Intomoney"));
		Integer i = bbiz.modifyBalanceReduce(user.getCardno(), money);
		Integer i2 = bbiz.modifyBalanceAddition(cardNum, money);
		if (i != 0 && i2 != 0) {
			response.getWriter().write("ok");
		}
	}

	/**
	 * 
	 * <p>
	 * Title: balance
	 * </p>
	 * <p>
	 * Description:查询余额
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void balance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String card = request.getParameter("card");
		// response.getWriter().write();
		String n = String.valueOf(bbiz.SelBalance(card));
		response.getWriter().write(n);
	}

	/**
	 * 
	 * <p>
	 * Title: selAllLog
	 * </p>
	 * <p>
	 * Description:根据日期查询所有余额
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selAllLog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		date1 = request.getParameter("date1");
		date2 = request.getParameter("date2");
		ptr = bbiz.SelLog(date1, date2, upPage, dowmPage);
		response.getWriter().write(JSON.toJSONString(ptr.getList()));
		System.out.println(JSON.toJSONString(ptr.getList()));
	}

	/**
	 * 
	 * <p>
	 * Title: nextPage
	 * </p>
	 * <p>
	 * Description: 下一页
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void nextPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (ptr.isHasNextPage()) {
			Integer next = ptr.getNextPage();
			ptr = bbiz.SelLog(date1, date2, next, dowmPage);
			response.getWriter().println(JSON.toJSONString(ptr.getList()));
		}
	}

	protected void previousPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (ptr.isHasPreviousPage()) {
			Integer last = ptr.getPrePage();
			ptr = bbiz.SelLog(date1, date2, last, dowmPage);
			response.getWriter().println(JSON.toJSONString(ptr.getList()));
		}
	}

	protected void updatePwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newpwd = request.getParameter("newpas");
		String oldpwd = request.getParameter("olopwd");
		Integer check = bbiz.modifyPwd(newpwd, user.getCardno(), oldpwd);
		if (check != 0) {
			response.getWriter().write("修改成功");
		}else {
			response.getWriter().write("修改失败");
		}
	}
}
