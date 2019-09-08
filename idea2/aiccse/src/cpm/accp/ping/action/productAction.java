package cpm.accp.ping.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cpm.accp.ping.biz.LoginBiz;
import cpm.accp.ping.entity.Product;
import cpm.accp.ping.entity.Role;
import cpm.accp.ping.entity.Use;
import cpm.accp.ping.util.PwdUilt;
import cpm.accp.ping.util.feupdate;

/**
 * Servlet implementation class productAction
 */
// url > /c/goods
public class productAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginBiz biz = new LoginBiz();
    String sfile = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * get请求
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台需要做什么事情
		String usr = request.getParameter("usr");
		if("login".equals(usr)) {
			this.login(request, response);
		}
		else if("addimg".equals(usr)) {
			this.addimg(request, response);
		}
		else if("selectcunt".equals(usr)) {
			this.selectCunt(request, response);
		}
		else if("selectPro".equals(usr)) {
			this.selectPro(request, response);
		}
		else if("updateuse".equals(usr)) {
			this.updateuse(request, response);
		}
		else if("selectuse".equals(usr)) {
			this.selectuse(request, response);
		}
		else if("outuse".equals(usr)) {
			//会话销毁
			request.getSession().removeAttribute("use");
			request.getSession().invalidate();
			response.getWriter().write("ok");
		}
		else if("deleterole".equals(usr)) {
			this.deleterole(request, response);
		}else if("usezing".equals(usr)) {
			this.useZing(request, response);
		}
		else if("selectuser".equals(usr)) {
			this.selectuser(request, response);
		}
		else if("addrole".equals(usr)) {
			this.addrole(request, response);
		}
		else if("deleteProduct".equals(usr)) {
			this.deleteProduct(request, response);
		}else if("selectRole".equals(usr)) {
			this.selectRole(request, response);
		}
		else if("getuser".equals(usr)){
			this.getuser(request, response);
		}else if("addproduct".equals(usr)){
			this.addproduct(request, response);
		}else if("manageProduct".equals(usr)) {
			String type = request.getParameter("type");
			String name = request.getParameter("name");
			this.manageProduct(request, response,type,name);
		}else if("updateProduct".equals(usr)){
			this.updateProduct(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

	/**post请求
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 用户登陆
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//登陆
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Use use = biz.login(name, pwd);
		if(use.getUsername() != null) {
			if(use.getUzing() != 0) { //判断是否冻结
				response.getWriter().write("你的用户已被冻结,联系管理员!");
			}else { //允许登陆
				HttpSession session  = request.getSession();
				session.setAttribute("use", use);
				response.getWriter().write("1");
				//人数
				Object val=request.getSession().getServletContext().getAttribute("COUNT");
		    	if(val!=null) {
		    		Integer count=(Integer)val;
		    		count++;
		    		request.getSession().getServletContext().setAttribute("COUNT",count);
		    	}
			}
		}else {
			response.getWriter().write("账户/密码出错");
		}
	}
	/**
	 * 用户获取登陆后个人信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getuser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//获取用户登陆信息
		HttpSession session  = request.getSession();
		Use u = (Use)session.getAttribute("use");
		Map<String, String> message = new HashMap<String, String>();
		PrintWriter out = response.getWriter();
		if (u != null) {
			message.put("code","200");
			message.put("msg", JSON.toJSONString(u) );
		} else {
			message.put("code", "300");
			message.put("msg", "user_error");
		}
		out.write(JSON.toJSONString(message));
		out.flush();
		out.close();
	}
	/**
	 * 添加商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addproduct(HttpServletRequest request , HttpServletResponse response)throws ServletException ,IOException{
		String jsor = request.getParameter("name");
		System.out.println(jsor);
		Product pro = JSON.parseObject(jsor,Product.class);
		if(sfile == "") {
			pro.setPimg("static/dynamic/liqi.jpg");
		}else {
			pro.setPimg(sfile);
			sfile = "";
		}
		if(pro != null) {
			// 消息集合
			Map<String, String> message = new HashMap<String, String>();
			try {
				biz.tddProduct(pro);
				message.put("code", "200");
				message.put("msg", "增加成功");
			} catch (Exception ex) {
				message.put("code", "500");
				message.put("msg", ex.getMessage());
			}
			response.getWriter().write(JSON.toJSONString(message));
		}
	}
	/**
	 * 查询所有商品
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	protected void manageProduct(HttpServletRequest request , HttpServletResponse response , String type ,String name)throws SecurityException,IOException{
		ArrayList<Product> pro = biz.selectProduct(type,name);
		response.getWriter().write(JSON.toJSONString(pro));
	}
	/**
	 * 修改商品信息
	 * @param request
	 * @param resp
	 * @throws SecurityException
	 * @throws IOException
	 */
	protected void updateProduct(HttpServletRequest request , HttpServletResponse response) throws SecurityException ,IOException{
		String jsor = request.getParameter("name");
		System.out.println(jsor);
		Product pro = JSON.parseObject(jsor,Product.class);
		if(sfile == "") {
			
		}else {
			pro.setPimg(sfile);
			sfile = "";
		}
		if(pro != null) {
			System.out.println(jsor);
			// 消息集合
			Map<String, String> message = new HashMap<String, String>();
			try {
				biz.updateProduct(pro);
				message.put("code", "200");
				message.put("msg", "修改成功");
			} catch (Exception ex) {
				message.put("code", "500");
				message.put("msg", ex.getMessage());
				
			}
			response.getWriter().write(JSON.toJSONString(message));
		}
	}
	/**
	 * 删除商品
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	protected void deleteProduct(HttpServletRequest request , HttpServletResponse response) throws SecurityException ,IOException{
		String pid = request.getParameter("pid");
		System.out.println(pid);
		if(pid != null) {
			// 消息集合
			Map<String, String> message = new HashMap<String, String>();
			try {
				biz.deleteProduct(pid);
				message.put("code", "200");
				message.put("msg", "删除成功");
			} catch (Exception ex) {
				message.put("code", "500");
				message.put("msg", ex.getMessage());
			}
			response.getWriter().write(JSON.toJSONString(message));
		}
	}
	/**
	 * 获取所有角色
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	protected void selectRole(HttpServletRequest request,HttpServletResponse response)throws SecurityException, IOException {
		ArrayList<Role> list = biz.selectRole();
		response.getWriter().write(JSON.toJSONString(list));
	}
	/**
	 * 添加管理员
	 * @param request
	 * @param response >
	 * @throws SecurityException
	 * @throws IOException
	 */
	protected void addrole(HttpServletRequest request ,HttpServletResponse response)throws SecurityException,IOException{
		String jsor = request.getParameter("uses");
		System.out.println(jsor);
		Use u = (Use)JSON.parseObject(jsor, Use.class);
		Role role = biz.selectRole(u.getRid());
		u.setRo(role);
		if(u != null) {
			System.out.println(jsor);
			// 消息集合
			Map<String, String> message = new HashMap<String, String>();
			try {
				biz.intoRole(u);
				message.put("code", "200");
				message.put("msg", "添加成功");
			} catch (Exception ex) {
				message.put("code", "500");
				message.put("msg", ex.getMessage());
				
			}
			response.getWriter().write(JSON.toJSONString(message));
		}
	}
	/**
	 * 查询所有用户
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	protected void selectuser(HttpServletRequest request,HttpServletResponse response)throws SecurityException, IOException{
		ArrayList<Use> list = biz.selectUses();
		response.getWriter().write(JSON.toJSONString(list));
	}
	/**
	 * 删除管理员
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	protected void deleterole(HttpServletRequest request,HttpServletResponse response)throws SecurityException, IOException {
		String uid = request.getParameter("uid");
		System.out.println(uid+"uid");
		if(uid != null) {
			// 消息集合
			Map<String, String> message = new HashMap<String, String>();
			try {
				biz.deleteRole(uid);
				message.put("code", "200");
				message.put("msg", "删除成功");
			} catch (Exception ex) {
				message.put("code", "500");
				message.put("msg", ex.getMessage());
				
			}
			response.getWriter().write(JSON.toJSONString(message));
		}
	}
	/**
	 * 查询用户
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	private void selectuse(HttpServletRequest request,HttpServletResponse response)throws SecurityException,IOException{
		String uid = request.getParameter("uid");
		Use u = biz.selectUse(uid);
		response.getWriter().write(JSON.toJSONString(u));
	}
	/**
	 * 修改用户
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	private void updateuse(HttpServletRequest request,HttpServletResponse response)throws SecurityException,IOException{
		String jsor = request.getParameter("name");
		Use u = (Use)JSON.parseObject(jsor, Use.class);
		if(u != null) {
			// 消息集合
			Map<String, String> message = new HashMap<String, String>();
			try {
				biz.updatause(u);
				message.put("code", "200");
				message.put("msg", "修改成功");
			} catch (Exception ex) {
				message.put("code", "500");
				message.put("msg", ex.getMessage());
				
			}
			response.getWriter().write(JSON.toJSONString(message));
		}
	}
	/**
	 * 查询商品
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	private void selectPro(HttpServletRequest request,HttpServletResponse response)throws SecurityException,IOException {
		String id = request.getParameter("id");
		Product pro = biz.selectPro(id);
		response.getWriter().write(JSON.toJSONString(pro));
	}
	/**
	 * 获取在线人数
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	private void selectCunt(HttpServletRequest request,HttpServletResponse response)throws SecurityException,IOException {
		System.out.println("当前在线人数:"+request.getSession().getServletContext().getAttribute("COUNT").toString());
		response.getWriter().write(request.getSession().getServletContext().getAttribute("COUNT").toString());
//		response.getWriter().write("2");
	}
	/**
	 * 冻结用户
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 */
	private void useZing(HttpServletRequest request,HttpServletResponse response)throws SecurityException,IOException {
		String uid = request.getParameter("uid");
		if(uid != null) {
			// 消息集合
			Map<String, String> message = new HashMap<String, String>();
			try {
				biz.useZing(uid);
				message.put("code", "200");
				message.put("msg", "操作成功");
			} catch (Exception ex) {
				message.put("code", "500");
				message.put("msg", ex.getMessage());
				
			}
			response.getWriter().write(JSON.toJSONString(message));
		}
	}
	/**
	 * 图片上传
	 * @param request
	 * @param response
	 * @throws SecurityException
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void addimg(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException {
		sfile = new feupdate().sfile(request, response);
	}
	
}
