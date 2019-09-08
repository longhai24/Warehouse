package com.shenhai.say.util;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**相当于代理规则
 * @author 偏执狂
 *
 */
public class TransCallBack implements MethodInterceptor {

	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		Object result=null;
		try {
			result=arg3.invokeSuper(arg0, arg2);
			if(arg1.getName().startsWith("add")||
			   arg1.getName().startsWith("modify")||
			   arg1.getName().startsWith("remove")) {
			   SqlSessionUtil.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			SqlSessionUtil.rollback();
			LoggerUtil.error("方法调用失败",e);
			throw new RuntimeException("方法调用失败",e);
		}finally {
			SqlSessionUtil.close();
		}
		return result;
	}

	

}
