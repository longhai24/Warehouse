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
	//����洢����������
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
		//��õ�ǰ����·��
		String reqPath=request.getRequestURI();// /WebFilter/sessionerror.html
		//���˰�����
		for(String path:publicPages) {
			if(reqPath.equals(request.getContextPath()+"/"+path)) {
				chain.doFilter(request, response);
				return;
			}
		}
		//�ж��Ƿ��½
		if(request.getSession().getAttribute("use")==null) {
			//û��½��login
			response.sendRedirect(request.getContextPath()+"/ui/login.html");
		}else {
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		//��ó�ʼ�����������Ƽ���
		Enumeration<String> data=fConfig.getInitParameterNames();
		while(data.hasMoreElements()) {
			publicPages.add(fConfig.getInitParameter(data.nextElement()));
		}
	}

}
