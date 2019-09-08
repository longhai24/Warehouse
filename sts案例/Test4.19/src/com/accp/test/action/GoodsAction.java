package com.accp.test.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.test.biz.GoodsBiz;
import com.accp.test.entity.Goods;
import com.accp.test.entity.GoodsClass;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class GoodsAction
 */
public class GoodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GoodsAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		GoodsBiz gbiz = new GoodsBiz();
		String method = request.getParameter("method");
		if ("selAll".equals(method)) {
			response.getWriter().write(JSON.toJSONString(gbiz.SelAll()));
		}else if ("del".equals(method)) {
			Map<String, String> message = new HashMap<>();
			Integer did = Integer.valueOf(request.getParameter("did"));
			try {
				gbiz.DelGoods(did);
				message.put("fir", "200");
				message.put("sec", "删除成功");
			} catch (Exception e) {
				message.put("fir", "500");
				message.put("sec", e.getMessage());
			}
			response.getWriter().write(JSON.toJSONString(message));
		}else if ("clazz".equals(method)) {
			ArrayList<GoodsClass> dlist = new ArrayList<>();
			dlist = gbiz.SelGoodsClazz();
			response.getWriter().write(JSON.toJSONString(dlist));
		}else if("add".equals(method)) {
			
			Goods good = JSON.parseObject(request.getParameter("no"),Goods.class);
			Map<String, String> message = new HashMap<>();
			try {
				gbiz.AddGoods(good);
				message.put("fir", "200");
				message.put("sec", "添加成功");
			} catch (Exception e) {
				message.put("fir", "500");
				message.put("sec", e.getMessage());
			}
			response.getWriter().write(JSON.toJSONString(message));
		}else if("update".equals(method)) {
			Goods good = JSON.parseObject(request.getParameter("no"),Goods.class);
			Map<String, String> message = new HashMap<>();
			try {
				gbiz.UpdateGoods(good);
				message.put("fir", "200");
				message.put("sec", "修改成功");
			} catch (Exception e) {
				message.put("fir", "500");
				message.put("sec", e.getMessage());
			}
			response.getWriter().write(JSON.toJSONString(message));
		}
	}
	
}
