package cpm.accp.ping.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AiccseFilter
 */
public class ReqCharsetFilter implements Filter {
	private String charset;
    /**
     * Default constructor. 
     */
    public ReqCharsetFilter() {
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
		response.setContentType("text/html;charset="+charset);
		response.setCharacterEncoding(charset);
		if(request.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding(charset);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see ��ʼ��
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//��ȡ��ʼ������
		charset=fConfig.getInitParameter("charset");
	}

}
