package com.accp.biz;

import com.accp.dao.IDao;
import com.accp.pojo.Invitation;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Biz {
    @Autowired
    private IDao dao;

    public  PageInfo<Invitation> SelAllInvitation(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Invitation> pageInfo = new PageInfo<Invitation>(dao.SelAllInvitation());
        return pageInfo;
    }

    public PageInfo<Invitation> SelSome(Integer pageNum, Integer pageSize, String title) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Invitation> pageInfo = new PageInfo<Invitation>(dao.SelSome(title));
        return pageInfo;
    }
}
