package com.tx.biz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tx.dao.IVote;
import com.tx.pojo.User;
import com.tx.pojo.tttr;
import com.tx.util.Encryption;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:投票业务逻辑操作层
 * @author: apple
 * @date: 2019-05-28 20:53
 */
public class VoteBiz {
    @Autowired
    private IVote idao;
    Encryption en = new Encryption();
    public User SelUser( String user, String pwd){
       pwd=en.strongEncryption(pwd);
        return idao.SelUser(user,pwd);
    }
    public Integer addVote( tttr t){
        return idao.addVote(t);
    }
    public PageInfo<tttr> selAllVote(Integer pageNum,Integer pageSize){
      PageHelper.startPage(pageNum,pageSize);
      PageInfo<tttr> page = new PageInfo<tttr>(idao.selAllVote());
      return  page;
    }
    public tttr selSome(Integer voteid){
        return  idao.selSome(voteid);
    }
    public Integer modifyCount ( String cname, Integer voteid,Integer num){
        return idao.modifyCount(cname,voteid,num);
    }
    public Integer addUser( User u){
        u.setUserPwd(en.strongEncryption(u.getUserPwd()));
        return idao.addUser(u);
    }

    public List<tttr> selCountLisr(){
        return  idao.selAllVote();
    }
    public Integer removeVote( Integer did){
        return  idao.removeVote(did);
    }
}
