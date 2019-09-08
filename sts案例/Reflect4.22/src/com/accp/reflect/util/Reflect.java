package com.accp.reflect.util;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.accp.reflect.entity.Model;

@SuppressWarnings("all")
public class Reflect {
	@ SuppressWarnings("all")
	public String Transform(Object obj) {
		String num = "{'";
		Class cla = obj.getClass();
		Field oname;
		Field oage;
		Field[] list;

		if (obj instanceof List) {
			try {
				for (Object f1 : (List<?>) obj) {
					for (Field f : f1.getClass().getDeclaredFields()) {
						f.setAccessible(true);
						num = num + f.getName() + "':'" + f.get(f1) + "'},";
					}
				}
				num = num + "]";
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				for (Field f : cla.getDeclaredFields()) {
					f.setAccessible(true);
					num = num + f.getName() + "':'" + f.get(obj) + "',";
				}
				num = num+"}";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return num;
	}
}
