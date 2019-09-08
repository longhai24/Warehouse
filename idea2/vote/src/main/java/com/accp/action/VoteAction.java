package com.accp.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.biz.VoteBiz;
import com.accp.pojo.Group;
import com.accp.pojo.Vote;
import com.accp.pojo.VotePail;
import com.accp.pojo.user;
import com.accp.util.SpringBeanUtil;
import com.accp.vo.*;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.test.util.JsonExpectationsHelper;

/**
 * Servlet implementation class VoteAction
 */
public class VoteAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VoteBiz biz = SpringBeanUtil.getBeanByName("biz");

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String src = request.getParameter("src");
        System.out.println(src + ":浏览器");
        if (src == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        } else if (src.startsWith("skip")) { // 跳页面
            this.skip(src, request, response);
        } else { // 操作
            try {
                Method method = this.getClass().getDeclaredMethod(src, HttpServletRequest.class,
                        HttpServletResponse.class);
                method.invoke(this, request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 跳页面
     *
     * @param src
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void skip(String src, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = src.substring(src.indexOf("-") + 1, src.length());
        if ("regs".equals(name)) {
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
        } else if ("in.html".equals(name)) {
            request.getRequestDispatcher("/WEB-INF/jsp/in.jsp").forward(request, response);
        } else if ("forms.html".equals(name)) {
            request.getRequestDispatcher("/WEB-INF/jsp/forms.jsp").forward(request, response);
        } else if ("tables.html".equals(name)) {
            HttpSession session = request.getSession();
            user obj = (user) session.getAttribute("user");
            PageHelper.startPage(1, 5);
            PageInfo pagainfo = new PageInfo(biz.findVps(obj.getUid()));
            request.setAttribute("pagainfo", pagainfo);
            request.getRequestDispatcher("/WEB-INF/jsp/tables.jsp").forward(request, response);
        } else if ("user.html".equals(name)) {
            request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
        }else if("components.html".equals(name)){
            request.getRequestDispatcher("/WEB-INF/jsp/Components.jsp").forward(request, response);
        }else if("notifications.html".equals(name)){
            request.getRequestDispatcher("/WEB-INF/jsp/Notifications.jsp").forward(request,response);
        }else if("jin".equals(name)){
            String vid = request.getParameter("vid");
            Vote v = biz.findVote(vid);
            Integer sun = biz.findjinsun(vid); //获取该选项投票人数
            double i = 100/sun;
            System.out.println(i +"百分比");
            List<VoSunVo>  list = biz.findjinjin(vid);//获取所有选项所得到得票
            FindJinSun jin = new FindJinSun();
            for (VoSunVo f:list) {
                System.out.println(f.getSun() +"票数");
                String aa=new String(f.getVoption().getBytes("iso-8859-1"),"utf-8");
                System.out.println(aa +"aa");
                System.out.println(v.getVoptionA()+ "A");
                if(v.getVoptionA() != null && v.getVoptionA().equals(aa)){//用户投票得选项 == 投票选项  A
                    jin.setVoptionA(v.getVoptionA());//
                    jin.setA(f.getSun()*i);//获取该选项所得票数得百分比
                }
                if(v.getVoptionB() != null && v.getVoptionB().equals(aa)){//用户投票得选项 == 投票选项  B
                    jin.setVoptionB(v.getVoptionB());//
                    jin.setB(f.getSun()*i);//获取该选项所得票数得百分比
                }
                if( v.getVoptionC() != null && v.getVoptionC().equals(aa)){//用户投票得选项 == 投票选项  C
                    jin.setVoptionC(v.getVoptionC());//
                    jin.setC(f.getSun()*i);//获取该选项所得票数得百分比
                }
                if(v.getVoptionD() != null && v.getVoptionD().equals(aa)){//用户投票得选项 == 投票选项  D
                    jin.setVoptionD(v.getVoptionD());//
                    jin.setD(f.getSun()*i);//获取该选项所得票数得百分比
                }
                if(v.getVoptionE() != null && v.getVoptionE().equals(aa) ){//用户投票得选项 == 投票选项  E
                    jin.setVoptionE(v.getVoptionE());//
                    jin.setE(f.getSun()*i);//获取该选项所得票数得百分比
                }


            }
            System.out.println(jin);
            System.out.println(v);
            request.setAttribute("v",v);
            request.setAttribute("jin",jin);
            request.getRequestDispatcher("/WEB-INF/jsp/jin.jsp").forward(request,response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    /**
     * 登陆
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void dllogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        user u = biz.login(name, pwd);
        if (u != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", u); //存储在session中
            String user = JSON.toJSONString(u);
            request.setAttribute("user", user); //将数据发送到jsp
            request.getRequestDispatcher("/WEB-INF/jsp/Managing.jsp").forward(request, response);
        } else {
            response.getWriter().write("<script type='text/javascript'>alert('账号或密码出错!')</script>");
        }
    }

    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserName = request.getParameter("UserName");
        String Password = request.getParameter("Password");
        String gid = request.getParameter("gid");
        String Email = request.getParameter("Email");
        UserVo uvo = new UserVo(UserName, Password, Email, gid);
        System.out.println(uvo);
        int i = biz.adduser(uvo);
        if (i > 0) {
            response.sendRedirect("vote");
        }
    }

    /**
     * 查询组织码
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid = request.getParameter("gid");
        Group g = biz.findGroup(gid);
        if (g != null) {
            response.getWriter().write("ok");
        } else {
            response.getWriter().write("on");
        }
    }

    /**
     * 修改用户资料
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void modifyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        ModifyUserVo u = JSON.parseObject(user, ModifyUserVo.class);
        HttpSession session = request.getSession();
        user obj = (user) session.getAttribute("user");
        u.setUid(obj.getUid());
        System.out.println(u);
        int i = biz.modifyUser(u);
        if (i > 0) {
            response.getWriter().write("ok");
        }
    }

    /**
     * 添加投票组群
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("vp");
        VotePail vp = (VotePail) JSON.parseObject(str, VotePail.class);
        HttpSession session = request.getSession();
        user obj = (user) session.getAttribute("user");
        vp.setU(obj);
        int i = biz.addVotep(vp);
        if (i > 0) {
            response.getWriter().write("ok");
        }
    }

    /**
     * 渲染桶
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findVp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        user obj = (user) session.getAttribute("user");
        List<VotePail> listVp = biz.findVp(obj.getUid());
        response.getWriter().write(JSON.toJSONString(listVp));
    }

    /**
     * 添加投票
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("str");
        AddVoteVo vote = JSON.parseObject(str, AddVoteVo.class);
        System.out.println(vote);
        int i = biz.addVote(vote);
        if (i > 0) {
            response.getWriter().write("ok");
        }
    }

    /**
     * 根据桶id查询桶
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findVotePail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vpid = request.getParameter("vpid");
        VotePail vp = biz.findVotePail(vpid);
        System.out.println(vp);
        response.getWriter().write(JSON.toJSONString(vp));
    }

    /**
     * 桶分页
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findVpPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        user obj = (user) session.getAttribute("user");
        String num = request.getParameter("num");
        PageHelper.startPage(Integer.valueOf(num), 5);
        PageInfo pagainfo = new PageInfo(biz.findVp(obj.getUid()));
        response.getWriter().write(JSON.toJSONString(pagainfo));
    }

    /**
     * 根据桶id修改桶数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void modifyVp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("vp");
        VotePail vp = (VotePail) JSON.parseObject(str, VotePail.class);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(vp);
        int i = biz.modifyVp(vp);
        if (i > 0) {
            response.getWriter().write("ok");
        }
    }

    /**
     * 根据桶id 查询该桶的所有投票  并分页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findVotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vpid = request.getParameter("vpid");
        String num = request.getParameter("num");
        if (num =="" || num ==null){
            PageHelper.startPage(1,5);
            PageInfo<Vote> votePage = new PageInfo<Vote>(biz.findVotes(vpid));
            response.getWriter().write(JSON.toJSONString(votePage));
        }else{
            PageHelper.startPage(Integer.valueOf(num),5);
            PageInfo<Vote> votePage = new PageInfo<Vote>(biz.findVotes(vpid));
            response.getWriter().write(JSON.toJSONString(votePage));
        }
    }
    /**
     * 根据vid查询他的对象
     * @param
     * @return
     */
    protected void findVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String vid = request.getParameter("vid");
            Vote v = biz.findVote(vid);
            response.getWriter().write(JSON.toJSONString(v));
    }

    /**
     * 修改投票
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void midifyVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("str");
        Vote vote = JSON.parseObject(str, Vote.class);
        int i = biz.modifyVote(vote);
        if(i>0){
            response.getWriter().write("ok");
        }
    }

    /**
     * 根据条件搜索
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findTermVps(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");//搜索名字
        String term = request.getParameter("term");//搜索条件
        HttpSession session = request.getSession();
        user obj = (user) session.getAttribute("user");
        System.out.println("条件:"+name+"***********"+term +"***********"+obj.getG().getGid());
        List<FindTermVpsVo> findTermVps = biz.findTermVps(name,term,obj.getG().getGid()); // 查询数据
        String sun = biz.findTermVpSun(name,term,obj.getG().getGid());//查询行数
        request.setAttribute("sun",sun);
        request.setAttribute("findTermVps",JSON.toJSONString(findTermVps));
        request.getRequestDispatcher("/WEB-INF/jsp/Components.jsp").forward(request, response);
    }

    /**
     * 进行投票渲染
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void enterVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vpid = request.getParameter("vpid");
        VotePail vp = biz.findnterVote(vpid);
        request.setAttribute("vp",vp);
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
    }

    /**
     * 提交投票
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void submitVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        user obj = (user) session.getAttribute("user");//获取用户
        List<AddPastVoteVo> list = new ArrayList<AddPastVoteVo>(); //创建添加投票集合
        Enumeration paramNames = request.getParameterNames(); //form表单里所有具有name属性的表单对象获取 返回枚举类型
        while (paramNames.hasMoreElements()) { //通过Enumeration的hasMoreElements()方法遍历 请求的每个对象
            String paramName = (String) paramNames.nextElement(); //获取name的值
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0 && !"src".equals(paramName)) {
                    AddPastVoteVo pv = new AddPastVoteVo(obj.getUid().toString(),paramName,paramValue);
                    list.add(pv);
                }
            }
        }
        for (AddPastVoteVo f:list) {
            System.out.println(f);
        }
        int i = biz.addsubmitVote(list);
        if(i>0){
            response.sendRedirect("vote");
        }
    }

    /**
     * 用户图片修改
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void modifyUserImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("123");
        String name = request.getParameter("name");
    }
}
