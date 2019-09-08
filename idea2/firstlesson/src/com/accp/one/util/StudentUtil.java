package com.accp.one.util;

import java.util.Comparator;

import com.accp.one.entity.StudentEntity;

public class StudentUtil implements Comparator<StudentEntity>{
	
	private String name;
	

	public StudentUtil(String name) {
		this.name = name;
	}


	@Override
	public int compare(StudentEntity o1, StudentEntity o2) {
		if("age".equals(name)) {
			return o1.getAge()-o2.getAge();
		}else {
			return o1.getId()-o2.getId();
		}
	}
	
}
