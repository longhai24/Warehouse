package com.tx.action;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.tx.biz.VoteBiz;
import com.tx.pojo.Mysum;
import com.tx.pojo.User;
import com.tx.pojo.tttr;
import com.tx.util.SpringBeanUtil;
import com.tx.util.fw;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:前后台数据交互 @author: apple @date: 2019-05-28 21:03
 */
public class VoteSubAction extends HttpServlet {
    Integer upPage = 1;
    Integer dowmPage = 2;
    User u = new User();
    Integer voteid;
    tttr vott = new tttr();
    PageInfo<tttr> php = new PageInfo<tttr>();
    private VoteBiz vbiz = SpringBeanUtil.getBeanByName("biz");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            String method = request.getParameter("method");
            if (method == null || "".equals(method)) {/*  ptr = biz.SelAllInvitation(upPage, dowmPage); request.setAttribute("list", ptr.getList());*/
                request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
            } else {
                Method mm = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
                Object returnVal = mm.invoke(this, request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * @description: 登录 @author: apple @date: 2019-05-28:43
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");


        u = vbiz.SelUser(name, pwd);
        if (u != null) {
            request.setAttribute("user", u);
            request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
        } else response.getWriter().write("<script>alert('登陆失败')</script>");
    }

    /**
     * @description: 跳转注册页面 @author: apple @date: 2019-05-28:43
     */
    protected void toregister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
    }

    /**
     * @description: 注册新用户 @author: apple @date: 2019-05-28:02
     */
    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        User u = new User();
        u.setUserName(name);
        u.setUserPwd(upwd);
        Integer i = vbiz.addUser(u);
        if (i != 0) {
            response.getWriter().write("<script>alert('注册成功，正在跳转登录界面')</script>");
            response.sendRedirect("VoteSubAction");
        } else {
            response.getWriter().write("<script>alert('注册失败')</script>");
        }
    }
    /**
     * @description: 前往新增投票界面 @author: apple @date: 2019-05-29:58
     */
    protected void toaddVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/addVote.jsp").forward(request, response);
    }

    /**
     * @description: 添加新的投票 @author: apple @date: 2019-05-31:17
     */
    protected void addVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fw f = new fw();
        tttr h = f.sfile(request, response);
        Integer i = vbiz.addVote(h);
        if (i != 0) response.getWriter().write("<script>alert('添加成功')</script>>");
        else response.getWriter().write("<script>alert('添加失败')</script>>");
    }

    /**
     * @description: 查询所有投票 @author: apple @date: 2019-05-31:38
     */
    protected void SelVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        php = vbiz.selAllVote(upPage, dowmPage);
        System.out.println(php.getList());
        response.getWriter().write(JSON.toJSONString(php.getList()));
    }

    /**
     * @description: 下一页 @author: apple @date: 2019-05-31:42
     */
    protected void NextPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (php.isHasNextPage()) {
            Integer next = php.getNextPage();
            php = vbiz.selAllVote(next, dowmPage);
            response.getWriter().println(JSON.toJSONString(php.getList()));
        }
    }

    /**
     * @description: 上一页 @author: apple @date: 2019-05-31:44
     */
    protected void DownPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (php.isHasPreviousPage()) {
            Integer lase = php.getPrePage();
            php = vbiz.selAllVote(lase, dowmPage);
            response.getWriter().println(JSON.toJSONString(php.getList()));
        }
    }

    /**
     * @description: 首页 @author: apple @date: 2019-05-31:57
     */
    protected void firPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer fir = php.getFirstPage();
        php = vbiz.selAllVote(fir, dowmPage);
        response.getWriter().println(JSON.toJSONString(php.getList()));
    }

    /**
     * @description: 尾页 @author: apple @date: 2019-05-31:57
     */
    protected void lastPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer las = php.getLastPage();
        php = vbiz.selAllVote(las, dowmPage);
        response.getWriter().println(JSON.toJSONString(php.getList()));
    }

    /**
     * @description: 前往投票 @author: apple @date: 2019-05-31:58
     */
    protected void toBeganVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("v");
        voteid = Integer.valueOf(name);
        vott = vbiz.selSome(voteid);
        request.setAttribute("li", vott);
        System.out.println(vott);
        request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);
    }

    /**
     * @description: 投票 @author: apple @date: 2019-05-31:32
     */
    protected void BeganVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c1 = request.getParameter("c1");
        String c2 = request.getParameter("c2");
        String c3 = request.getParameter("c3");
        String c4 = request.getParameter("c4");
        String a = "mei";
        Integer addnum = 0;
        if (c1 != null) {
            a = c1;
            addnum = vott.getVoteoption1poll() + 1;
        }
        if (c2 != null) {
            a = c2;
            addnum = vott.getVoteoption2poll() + 1;
        }
        if (c3 != null) {
            a = c3;
            addnum = vott.getVoteoption3poll() + 1;
        }
        if (c4 != null) {
            a = c4;
            addnum = vott.getVoteoption4poll() + 1;
        }
        System.out.println("要修改的列" + a + "编号" + vott.getVoteid() + "修改后的票数" + addnum);
        vbiz.modifyCount(a, vott.getVoteid(), addnum);
        request.getRequestDispatcher("WEB-INF/jsp/linear.jsp").forward(request,response);
    }
    /**
     * @description: 查看票数
     * @author: apple
     * @date: 2019-06-01:49
     */
    protected void tolinear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<tttr> countList = vbiz.selCountLisr();
        System.out.println(countList.size());
        List<Mysum> MySumList = new ArrayList<>();
        for (tttr t:countList
             ) {
            Mysum su = new Mysum();
            su.setName1(t.getVoteoption1());
            su.setName2(t.getVoteoption2());
            su.setName3(t.getVoteoption3());
            su.setName4(t.getVoteoption4());
            double i =(double)100/(t.getVoteoption1poll()+t.getVoteoption2poll()+t.getVoteoption3poll()+t.getVoteoption4poll());
                 su.setPo1(i*t.getVoteoption1poll());
                 su.setPo2(i*t.getVoteoption2poll());
                su.setPo3(i*t.getVoteoption3poll());
                su.setPo4(i*t.getVoteoption4poll());
                MySumList.add(su);

        }

        request.setAttribute("Votesum",MySumList);
        request.getRequestDispatcher("WEB-INF/jsp/linear.jsp").forward(request,response);
    }
    /**
     * @description: 删除投票
     * @author: apple
     * @date: 2019-06-01:08
     */
    protected void delVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer  did =   Integer.valueOf(request.getParameter("did"));
        vbiz.removeVote(did);
    }
}