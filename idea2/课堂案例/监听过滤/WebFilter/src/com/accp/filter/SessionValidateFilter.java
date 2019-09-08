package com.accp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SessionValidateFilter
 */
public class SessionValidateFilter implements Filter {
	
	private List<String> publicPages=new ArrayList<String>();

    /**
     * Default constructor. 
     */
    public SessionValidateFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//获得当前访问路径
		String reqPath=request.getRequestURI();// /WebFilter/sessionerror.html
		//过滤白名单
		for(String path:publicPages) {
			if(reqPath.equals(request.getContextPath()+"/"+path)) {
				chain.doFilter(request, response);
				return;
			}
		}
		
		if(request.getSession().getAttribute("USERS")==null) {
			response.sendRedirect(request.getContextPath()+"/sessionerror.html");
		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		Enumeration<String> data=fConfig.getInitParameterNames();//获得初始化参数的名称集合
		while(data.hasMoreElements()) {
			publicPages.add(fConfig.getInitParameter(data.nextElement()));
		}
	}

}
