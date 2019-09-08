package com.tx.Bank.biz;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tx.Bank.dao.IBank;
import com.tx.Bank.pojo.Account;
import com.tx.Bank.pojo.Transaction_record;

/**
 * 
* <p>Title: BankBiz</p>  
* <p>Description:逻辑操作层 </p>  
* @author Apple 

* @date 2019年5月24日
 */
public class BankBiz {

	@Autowired
	private IBank idao;
	
	public Account SelUser(String cardno,String password) {
		return idao.SelUser(cardno, password);
	}
	public int modifyBalanceReduce( String card,  Integer money) {
		return idao.modifyBalanceReduce(card, money);
	}
	public int modifyBalanceAddition( String card,  Integer money) {
		return idao.modifyBalanceAddition(card, money);
	}
	public Integer SelBalance(String card) {
		return idao.SelBalance(card);
	}
	public PageInfo<Transaction_record> SelLog(String date,String date2,Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<Transaction_record> pageInfo = new PageInfo<Transaction_record>(idao.SelLog(date, date2));
		return pageInfo;
	}
	public int modifyPwd(String newpas,String cardno,String oldpwd) {
		return idao.modifyPwd(newpas, cardno,oldpwd);
	}
}
