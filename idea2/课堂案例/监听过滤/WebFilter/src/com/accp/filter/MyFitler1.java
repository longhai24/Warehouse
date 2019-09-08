package com.accp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//1.实现接口
public class MyFitler1 implements Filter {

	public void destroy() {
		System.out.println("组件1销毁");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("组件1过滤");
		chain.doFilter(req, resp);//非常重要
		System.out.println("组件1过滤结束");
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("组件1初始化");
	}

}
