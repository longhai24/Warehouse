package com.accp.dao;

import com.accp.pojo.Invitation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDao {

    /**
     * 查询所有发帖
     * @return
     */
    public List<Invitation> SelAllInvitation();

    /**
     * 带参查询
     * @param title
     * @return
     */
    public List<Invitation> SelSome(@Param("title") String title );
}
