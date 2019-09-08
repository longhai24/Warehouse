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
* <p>Description:������ </p>  
* @author Apple 

* @date 2019��4��15��
 */
public class GoodsFilter implements Filter {

	public ArrayList<String> wlist  =new ArrayList<>();
    public GoodsFilter() {
    	System.out.println("����");
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//��ȡ��ҳ�Ϸ��ʵĵ�ַ
		String uri= request.getRequestURI();
		for (String i : wlist) {
								//��ȡ��ǰ���̵�ǰ׺
			System.out.println( request.getContextPath()+i);
			if ((request.getContextPath()+i).equals(uri)) {
				chain.doFilter(req, res);
				return;
				
			}
		}
		//�жϵ�¼�ɹ���Ĳ�������������ڿվ�����ͨ���������ص�¼ҳ��ǿ�ȵ�¼
		if (request.getSession().getAttribute("LoginType")!= null) {
			chain.doFilter(req, res);
		}
		else {
			response.sendRedirect("http://localhost:8080/Goods/html/login.html");
		}
	}
	
	//��ʼ��
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("��ʼ��");
		//��ȡxml������������ֵļ���	
		Enumeration<String> list =fConfig.getInitParameterNames();
		//������������õ����������
		while (list.hasMoreElements()) {
			//ֻ��һ����ʱ���ü�����ȡ
			//String i= fConfig.getInitParameter("xml�����õĲ�����")
			//�Ѱ���������ļ��ϴ浽��һ����������
			wlist.add(fConfig.getInitParameter(list.nextElement()));
			
		}
		System.out.println("��ʼ���ɹ�");
	}

}
