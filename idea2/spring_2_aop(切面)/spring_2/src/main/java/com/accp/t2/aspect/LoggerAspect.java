package com.accp.t2.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggerAspect {
	
	public void doLogger(JoinPoint jp) {
		System.out.println("您进入了"+jp.getSignature().getName()+"方法操作");
	}

}
