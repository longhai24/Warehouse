package com.accp.t3.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.accp.t3.biz.PersonBiz;
import com.accp.t3.util.SpringBeanUtil;

@SuppressWarnings("all")
public class PersonAction extends HttpServlet {
	
	private PersonBiz personBiz=SpringBeanUtil.getBeanByName("biz");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String method = req.getParameter("m");
		try {
			this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class).invoke(this,
					req, resp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void personList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pageNum = Integer.parseInt(request.getParameter("p"));
		Integer pageSize = Integer.parseInt(request.getParameter("s"));
		request.setAttribute("PAGE_INFO", personBiz.findPersonListByPage(pageNum, pageSize));
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);

	}

	public void load(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("PERSON", personBiz.getPersonById(id));
		request.getRequestDispatcher("/WEB-INF/view/info.jsp").forward(request, response);

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		personBiz.removePersonById(id);
		response.sendRedirect(request.getContextPath() + "/person?m=personList&p=1&s=3");

	}

}
