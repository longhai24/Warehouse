package com.accp.test;

import java.lang.reflect.Field;
import java.util.List;

public class json {
	public String toJson(Object obj) throws Exception, IllegalAccessException {
		String val = "";
		if (obj instanceof java.util.List) {
			List<?> list = ((java.util.List) obj);
			for (Object c : list) {
				val = val +"{";
				Class cls = c.getClass();
				for(Field f:cls.getDeclaredFields()) {
//					System.out.println(f.getName());
					f.setAccessible(true);
					//通过属性名获得列值
					val = val + "'"+f.getName()+"':"+"'"+f.get(c)+",";
				}
				val = val +"},";
			}
			val ="\"["+val+"]\"";
		}else {
			Class cls = obj.getClass();
			for(Field f:cls.getDeclaredFields()) {
				f.setAccessible(true);
				//通过属性名获得列值
				val = val + "'"+f.getName()+"':"+"'"+f.get(obj)+",";
			}
			val ="\"{"+val+"}\"";
		}
		
		return val;
	}
	private void listT(Object obj) {
		if (obj instanceof List) {
			List<?> list = ((List) obj);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof List) {
					
				}
			}
		}else {
			
		}
	}
}
