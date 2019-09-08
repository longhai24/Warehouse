package com.accp.one.test;

import java.util.ArrayList;

import com.accp.one.biz.StudentBiz;
import com.accp.one.entity.StudentEntity;

public class StudentTest {
	public static void main(String[] args) {
		StudentBiz biz = new StudentBiz();
		ArrayList<StudentEntity> list = biz.select();
		for (StudentEntity i : list) {
			System.out.println(i);
		}
	}
}
