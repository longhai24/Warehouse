package cpm.accp.ping.filter;

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
 * Servlet Filter implementation class WhiteFilter
 */
public class WhiteFilter implements Filter {
	//定义存储白名单集合
	private List<String> publicPages=new ArrayList<String>();
	
    public WhiteFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
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
		//判断是否登陆
		if(request.getSession().getAttribute("use")==null) {
			//没登陆跳login
			response.sendRedirect(request.getContextPath()+"/ui/login.html");
		}else {
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		//获得初始化参数的名称集合
		Enumeration<String> data=fConfig.getInitParameterNames();
		while(data.hasMoreElements()) {
			publicPages.add(fConfig.getInitParameter(data.nextElement()));
		}
	}

}
