package com.tx.dao;

import com.tx.pojo.User;
import com.tx.pojo.tttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:投票接口
 * @author: apple
 * @date: 2019-05-28 20:44
 */
public interface IVote {

    /**
     * @description: 根据用户名和密码查找对应用户
     * @author: apple
     * @date: 2019-05-28:57
     */
    public User SelUser(@Param("name") String user, @Param("pwd") String pwd);

    /**
     * @description: 添加新用户
     * @author: apple
     * @date: 2019-05-28:59
     */
    public Integer addUser(@Param("u") User u);

    /**
     * @description: 新增新的投票
     * @author: apple
     * @date: 2019-05-31:37
     */
    public Integer addVote(@Param("vote") tttr t);
    
    /**
     * @description: 查看所有投票
     * @author: apple
     * @date: 2019-05-31:19
     */
    public List<tttr> selAllVote();
    
    /**
     * @description: 根据id查询投票详情
     * @author: apple
     * @date: 2019-05-31:28
     */
    public tttr selSome(@Param("v") Integer voteid);
    
    /**
     * @description: 进行投票计数
     * @author: apple
     * @date: 2019-05-31:38
     */
    public Integer modifyCount (@Param("cname") String cname,@Param("vid") Integer voteid,@Param("num") Integer num);

    /**
     * @description: 根据投票id删除投票
     * @author: apple
     * @date: 2019-06-01:57
     */
    public Integer removeVote(@Param("did") Integer did);
}
