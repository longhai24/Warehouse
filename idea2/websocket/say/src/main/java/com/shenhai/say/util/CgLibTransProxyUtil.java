package com.shenhai.say.util;

import net.sf.cglib.proxy.Enhancer;

public class CgLibTransProxyUtil {
	private CgLibTransProxyUtil() {
	}

	public static <T> T getTransProxyObject(Class superClass) {
		// 1.利用字节码技术动态创建代理对象
		Enhancer enhancer = new Enhancer();
		// 2.设置父类
		enhancer.setSuperclass(superClass);
		// 3.设置回调函数【规则】
		enhancer.setCallback(new TransCallBack());
		// 4.创建对象
		return (T) enhancer.create();
	}

}
