package com.accp.t6.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
	
	private Object obj;
	
	public MyHandler(Object target) {
		this.obj=target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限数据验证逻辑");
		Object returnVal=method.invoke(obj, args);//调用委托类的方法
		System.out.println("日志处理逻辑");
		return returnVal;
	}

}
