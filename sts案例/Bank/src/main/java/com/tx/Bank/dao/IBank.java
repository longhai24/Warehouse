package com.tx.Bank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tx.Bank.pojo.Account;
import com.tx.Bank.pojo.Transaction_record;

/**
 * 
 * <p>
 * Title: IBank
 * </p>
 * <p>
 * Description:dao层接口
 * </p>
 * 
 * @author Apple
 * 
 * @date 2019年5月24日
 */
public interface IBank {
	/**
	 * 
	 * <p>
	 * Title: SelUser
	 * </p>
	 * <p>
	 * Description:根据密码和账号查询对应用户信息
	 * </p>
	 * 
	 * @param cardno
	 * @param password
	 * @return
	 */
	public Account SelUser(@Param("cardno") String cardno, @Param("password") String password);

	/**
	 * 
	 * <p>Title: modifyBalanceReduce</p>  
	 * <p>Description:根据账号扣除余额 </p>  
	 * @param card
	 * @param money
	 * @return
	 */
	public int modifyBalanceReduce(@Param("card") String card, @Param("money") Integer money);

	/**
	 * 
	 * <p>Title: modifyBalanceAddition</p>  
	 * <p>Description:根据账号增加余额 </p>  
	 * @param card
	 * @param money
	 * @return
	 */
	public int modifyBalanceAddition(@Param("card") String card, @Param("money") Integer money);

	/**
	 * 
	 * <p>Title: SelBalance</p>  
	 * <p>Description: 根据账号查询余额</p>  
	 * @param card
	 * @return
	 */
	public Integer SelBalance(@Param("cardno")String card);
	
	/**
	 * 
	 * <p>Title: SelLog</p>  
	 * <p>Description: 查询日期内的所有记录</p>  
	 * @param date
	 * @param date2
	 * @return
	 */
	public List<Transaction_record> SelLog(@Param("date1")String date,@Param("date2")String date2);

	/**
	 * 
	 * <p>Title: modifyPwd</p>  
	 * <p>Description:修改密码 </p>  
	 * @param newpas
	 * @return
	 */
	public int modifyPwd(@Param("newpas")String newpas,@Param("user")String cardno,@Param("oldpwd")String oldpwd) ;
}
