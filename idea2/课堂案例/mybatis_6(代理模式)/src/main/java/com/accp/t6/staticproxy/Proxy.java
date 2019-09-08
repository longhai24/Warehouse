package com.accp.t6.staticproxy;

public class Proxy implements ProxyInterface{
	
	private Target target;
	
	public Proxy(Target target) {
		this.target=target;
	}

	@Override
	public void method1() {
		System.out.println("权限数据验证逻辑");
		target.method1();
		System.out.println("日志处理逻辑");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}	
	
}
