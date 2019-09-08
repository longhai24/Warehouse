package com.accp.Goods.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.accp.Goods.biz.GoodsBiz;
import com.accp.Goods.entity.Most1;
import com.accp.Goods.entity.Productdescription;
import com.accp.Goods.entity.Users;
import com.accp.Goods.util.feupdate;
import com.alibaba.fastjson.JSON;
import com.sun.prism.Mesh;

/**
 * 
 * <p>
 * Title: GoodsAction
 * </p>
 * <p>
 * Description:Servlet操作层
 * </p>
 * 
 * @author Apple
 * 
 * @date 2019年4月10日
 */
public class GoodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sfile="";
	GoodsBiz Gbiz = new GoodsBiz();

	public GoodsAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("login".equals(method)) {
			this.Glogin(request, response);
			
		} else if ("add".equals(method)) {
			this.GaddProduct(request, response);
		} else if ("selPro".equals(method)) {
			this.GselectAllPro(request, response);
		} else if ("selImg".equals(method)) {
			this.GselImg(request, response);
		} else if ("updatePro".equals(method)) {
			this.GupdatePro(request, response);
		} else if ("del".equals(method)) {
			this.GdelPro(request, response);
		} else if ("selSome".equals(method)) {
			this.GselectSome(request, response);
		} else if ("selMo".equals(method)) {
			this.GselMo(request, response);
		} else if ("delUser".equals(method)) {
			this.GdelUser(request, response);
		} else if ("updateUser".equals(method)) {
			this.GupdateUser(request, response);
		} else if ("toUpdate".equals(method)) {
			this.GselectUserById(request, response);
		}else if ("addUser".equals(method)) {
			this.GaddUser(request, response);
		}else if ("LoginType".equals(method)) {
			response.getWriter().write(request.getSession().getServletContext().getAttribute("COUNT").toString());
		}else if("delSession".equals(method)) {
			request.getSession().removeAttribute("LoginType");
			request.getSession().invalidate();
		}else if ("recover".equals(method)) {
			this.GRecover(request, response);
		}else if("uploading".equals(method)) {
			this.GUploading(request, response);
		}
	}

	public void GUploading(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		sfile =new feupdate().sfile(request,response);
		System.out.println(sfile);
	}
	public void GRecover(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		Map<String, String> message = new HashMap<>();
		Integer nuid = Integer.valueOf(request.getParameter("nuid"));
		
		try {
			Gbiz.RecoverUser(nuid);
			message.put("fir", "200");
			message.put("sec", "恢复成功");
		} catch (Exception e) {
			message.put("fir", "500");
			message.put("sec","恢复失败");
		}
		response.getWriter().write(JSON.toJSONString(message));
	}
	
	public void GaddUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String juser = request.getParameter("i");
			Users user = JSON.parseObject(juser, Users.class);
			Map<String, String> message = new HashMap<>();
			try {
				Gbiz.addUser(user);
				message.put("fir", "200");
				message.put("sec", "添加成功");
			} catch (Exception e) {
				message.put("fir", "500");
				message.put("sec", "添加失败");
			}
			response.getWriter().write(JSON.toJSONString(message));
	}
	
	public void GselectUserById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer uid1 = Integer.valueOf(request.getParameter("uid1"));
		String json = JSON.toJSONString(Gbiz.SelectUserById(uid1));
		response.getWriter().write(json);
	}

	public void GupdateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("i");
		Users use = JSON.parseObject(user, Users.class);
		System.out.println(use);
		Map<String, String> message = new HashMap<>();
		try {
			Gbiz.UpdateUser(use);
			message.put("fir", "200");
			message.put("sec", "修改成功");
		} catch (Exception e) {
			message.put("fir", "500");
			message.put("sec", "修改不成功");
		}
		response.getWriter().write(JSON.toJSONString(message));
	}

	public void GdelUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer did = Integer.valueOf(request.getParameter("did"));
		Map<String, String> message = new HashMap<>();
		try {
			Gbiz.LogoutUser(did);
			message.put("fir", "200");
			message.put("sec", "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			message.put("fir", "500");
			message.put("sec", e.getMessage());
		}
		response.getWriter().write(JSON.toJSONString(message));
	}

	public void GselMo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Most1> list = Gbiz.SelAllUser();
		String json = JSON.toJSONString(list);
		response.getWriter().write(json);

	}

	public void GselectSome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String word = request.getParameter("word");
		String json = JSON.toJSONString(Gbiz.SelProBySome(type, word));
		System.out.println(json);
		response.getWriter().write(json);
	}

	public void GdelPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String did = request.getParameter("did");
		Map<String, String> message = new HashMap<>();
		try {
			Gbiz.DeletePro(did);
			message.put("fir", "200");
			message.put("sec", "删除成功");
		} catch (Exception e) {
			message.put("fir", "500");
			message.put("sec", e.getMessage());
		}
		response.getWriter().write(JSON.toJSONString(message));
	}

	public void GselImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid1");
		String img = Gbiz.SelProImg(pid);
		response.getWriter().write(img);
	}

	public void GselectAllPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Productdescription> list = Gbiz.SelectAllPro();
		String Nlist = JSON.toJSONString(list);
		response.getWriter().write(Nlist);
	}

	public void GupdatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("i");
		Productdescription pro = JSON.parseObject(pid, Productdescription.class);
		pro.setPimg(sfile);
		sfile ="";
		Map<String, String> message = new HashMap<>();
		try {
			Gbiz.UpdatePro(pro);
			message.put("fir", "200");
			message.put("sex", "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			message.put("fir", "500");
			message.put("sex", e.getMessage());
		}
		response.getWriter().write(JSON.toJSONString(message));
	}

	public void GaddProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String asd = request.getParameter("i");
		Map<String, String> message = new HashMap<String, String>();
		Productdescription pro1 = JSON.parseObject(asd, Productdescription.class);
		pro1.setPimg(sfile);
		sfile ="";
		try {
			Gbiz.addProuduct(pro1);
			message.put("fir", "200");
			message.put("sec", "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			message.put("fir", "500");
			message.put("sec", e.getMessage());
		}
		response.getWriter().write(JSON.toJSONString(message));
	}

	public void Glogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		String upwd = request.getParameter("upwd");
		Users u = Gbiz.Login(uid, upwd);
		if (u != null) {
			String newU = JSON.toJSONString(u);
			response.getWriter().write(newU);
			request.getSession().setAttribute("LoginType", "ok");
			Object val=request.getSession().getServletContext().getAttribute("COUNT");
	    	if(val!=null) {
	    		Integer count=(Integer)val;
	    		count++;
	    		request.getSession().getServletContext().setAttribute("COUNT",count);
	    	}
		} else {
			String newU1 = JSON.toJSONString(u);
			response.getWriter().write(newU1);
	}
	}
}

