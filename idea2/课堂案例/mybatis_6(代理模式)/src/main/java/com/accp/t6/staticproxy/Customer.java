package com.accp.t6.staticproxy;

import java.lang.reflect.Proxy;

import com.accp.t6.javaproxy.MyHandler;

public class Customer {

	public static void invoke(ProxyInterface i) {
		System.out.println("客户端调用");
		i.method1();
	}

	public static void main(String[] args) {
		// invoke(new Proxy(new Target()));//静态代理
		// 动态代理使用
		Target target = new Target();// 委托
		// 构建代理对象
		ProxyInterface i = (ProxyInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new MyHandler(target));
		i.method2();

	}

}
