package com.accp.t6.util;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TransCallBack implements MethodInterceptor {

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mp) throws Throwable {
		Object returnVal = null;
		try {
			returnVal = mp.invokeSuper(proxy, args);// 委托对象的方法
			// 以add 或者 remove 或者modify开头的方法将会开启事务
			if (method.getName().startsWith("add") || method.getName().startsWith("remove")
					|| method.getName().startsWith("modify")) {
				SqlSessionUtil.commit();
			}
		} catch (Exception ex) {
			LoggerUtil.error("事务提交失败", ex);
			SqlSessionUtil.rollback();
			throw new RuntimeException(ex.getCause());
		} finally {
			SqlSessionUtil.closeSession();
		}
		return returnVal;
	}

}
