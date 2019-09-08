package com.accp.reflect.test;

import java.util.ArrayList;
import java.util.List;

import com.accp.reflect.entity.Model;
import com.accp.reflect.util.Reflect;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reflect ref = new Reflect();
		Model m1 = new Model();
		ArrayList<Model> list = new ArrayList<>();
		m1.setAge(12);
		m1.setName("lisi");
		list.add(m1);
		String i = ref.Transform( m1);
		System.out.println(i);
	}

}
