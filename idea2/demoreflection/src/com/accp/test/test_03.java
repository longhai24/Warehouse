package com.accp.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accp.entity.Book;
import com.alibaba.fastjson.JSON;

public class test_03 {
	public static void main(String[] args) throws Exception {
		Book b = new Book(1,"大海","书籍"); Book a = new Book(1,"小海","书籍");
		ArrayList<Book> list = new ArrayList<Book>();    list.add(b);   list.add(a);
		Map<Integer,List<?>> list2 = new HashMap<>(); list2.put(1, list);
		Class cls = Class.forName("com.accp.test.json");
		Object obj = cls.newInstance();
		Method m = cls.getDeclaredMethod("toJson",Object.class);
		Object retrunjson =  m.invoke(obj,list);
		System.out.println(retrunjson);
//		m(10); 
	}
	public static void m(int i) { 
	    if (i == 1) { 
	      System.out.println("1*1=1 "); 
	    } else { 
	      m(i - 1); 
	      for (int j = 1; j <= i; j++) { 
	        System.out.print(j + "*" + i + "=" + j * i + " "); 
	      } 
	      System.out.println(); 
	    } 
	  }  
}
