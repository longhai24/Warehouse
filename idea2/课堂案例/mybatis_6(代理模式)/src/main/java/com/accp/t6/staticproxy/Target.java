package com.accp.t6.staticproxy;

public class Target implements ProxyInterface {

	@Override
	public void method1() {
		// 省略一万行
		System.out.println("逻辑C......");
		
	}

	@Override
	public void method2() {
		// 省略一万行
		System.out.println("逻辑D.......");
	}

	@Override
	public void method3() {
		// 省略一万行
		System.out.println("逻辑F.......");
	}
}
