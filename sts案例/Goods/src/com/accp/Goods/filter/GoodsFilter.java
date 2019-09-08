package com.accp.Goods.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
* <p>Title: GoodsFilter</p>  
* <p>Description:拦截器 </p>  
* @author Apple 

* @date 2019年4月15日
 */
public class GoodsFilter implements Filter {

	public ArrayList<String> wlist  =new ArrayList<>();
    public GoodsFilter() {
    	System.out.println("生成");
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//获取网页上访问的地址
		String uri= request.getRequestURI();
		for (String i : wlist) {
								//获取当前工程的前缀
			System.out.println( request.getContextPath()+i);
			if ((request.getContextPath()+i).equals(uri)) {
				chain.doFilter(req, res);
				return;
				
			}
		}
		//判断登录成功后的操作，如果不等于空就让他通过否则跳回登录页面强迫登录
		if (request.getSession().getAttribute("LoginType")!= null) {
			chain.doFilter(req, res);
		}
		else {
			response.sendRedirect("http://localhost:8080/Goods/html/login.html");
		}
	}
	
	//初始化
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("初始化");
		//获取xml里面白名单名字的集合	
		Enumeration<String> list =fConfig.getInitParameterNames();
		//遍历这个集合拿到里面的名字
		while (list.hasMoreElements()) {
			//只有一个的时候不用集合提取
			//String i= fConfig.getInitParameter("xml里设置的参数名")
			//把白名单里面的集合存到另一个集合里面
			wlist.add(fConfig.getInitParameter(list.nextElement()));
			
		}
		System.out.println("初始化成功");
	}

}
