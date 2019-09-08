package com.accp.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.biz.GoodsBiz;
import com.accp.entity.GoodsEntity;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class GoodsAction
 */
public class GoodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GoodsAction() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		String usr = request.getParameter("usr");
		GoodsBiz biz = new GoodsBiz();
		if("delete".equals(usr)) {
			String id = request.getParameter("id");
			int i = biz.delete(id);
			if(i >0) {
				response.getWriter().write("1");
			}
		}else if("select".equals(usr)){
			ArrayList<GoodsEntity> list = biz.selectGoods();
			String jsor = JSON.toJSONString(list);
			response.getWriter().write(jsor);
		}else if("selectcl".equals(usr)) {
			response.getWriter().write(JSON.toJSONString(biz.selectc()));
		}else if("into".equals(usr)) {
			String name = request.getParameter("name");
			System.out.println(name);
			GoodsEntity g = JSON.parseObject(name, GoodsEntity.class);
			int i = biz.update(g);
			if(i>0) {
				response.getWriter().write("1");
			}
		}else if("liqi".equals(usr)) {
			String name = request.getParameter("name");
			System.out.println(name);
			GoodsEntity g = JSON.parseObject(name, GoodsEntity.class);
			int i = biz.liqi(g);
			if(i>0) {
				response.getWriter().write("1");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
