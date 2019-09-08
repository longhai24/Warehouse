package com.tx.Bank.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tx.Bank.biz.BankBiz;
import com.tx.Bank.pojo.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-ctx.xml"})
public class BankTest {

	@Autowired
	private BankBiz bankBiz;

	@Test
	public void testQueryPerson() {
		String cardno = "001";
		String password = "123";
		Account a = bankBiz.SelUser(cardno, password);
		System.out.println(a);
	}
}
