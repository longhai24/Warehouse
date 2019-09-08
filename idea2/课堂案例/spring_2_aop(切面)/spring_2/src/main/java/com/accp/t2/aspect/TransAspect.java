package com.accp.t2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class TransAspect {
	
	public Object doTrans(ProceedingJoinPoint pjp) {
		Long t1=System.currentTimeMillis();
		System.out.println("开启事务");
		Object val;
		try {
			val = pjp.proceed();//执行连接点 【非常重要】
			Long t2=System.currentTimeMillis();
			System.out.println("提交事务,用时"+(t2-t1)+"毫秒");
			return val;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
