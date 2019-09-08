package com.accp.work1.util;

import java.util.Comparator;

import com.accp.work1.entity.Stu;

/**
 * 
* <p>Title: MyComparator</p>  
* <p>Description:���򷽷� </p>  
* @author Apple 

* @date 2019��4��2��
 */
public class MyComparator implements Comparator<Stu> {

	public String Tname;

	

	public MyComparator(String tname) {
		super();
		Tname = tname;
	}

	@Override
	public int compare(Stu o1, Stu o2) {
		//�ж�Ҫ���������ǽ���
		if ("age".equals(Tname)) {
			//���������
			return o2.getStuAge()-o1.getStuAge();
		}
		else {
			//����Ӧ���ǽ���
			return o1.getStuId()-o2.getStuId();
		}
	}
	
}
