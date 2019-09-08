package com.accp.action;

import com.accp.biz.Biz;
import com.accp.pojo.Invitation;
import com.accp.util.SpringBeanUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class Action extends HttpServlet {
    private Biz biz = SpringBeanUtil.getBeanByName("biz");
    Integer upPage = 1;/* 起始页数*/
    Integer dowmPage = 2;/* 要看那一页*/
    PageInfo<Invitation> ptr;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");
        try {
            String method = request.getParameter("method");
            if (method==null ||"".equals(method)){
               ptr = biz.SelAllInvitation(upPage, dowmPage);
                request.setAttribute("list",ptr.getList());
                request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);
        }else {
                Method mm = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
                Object returnVal = mm.invoke(this, request, response);
            }
        } catch (Exception e) {/* TODO Auto-generated catch block*/
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void selSome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tit = request.getParameter("tit");
        response.getWriter().write(JSON.toJSONString(biz.SelSome(upPage,dowmPage,tit).getList()));
    }

    protected void down(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ptr.isHasNextPage()){
            Integer down = ptr.getNextPage();
            ptr = biz.SelAllInvitation(down,dowmPage);
            response.getWriter().write(JSON.toJSONString(ptr.getList()));
        }
    }


}
