package com.accp.work1.util;

import java.util.Comparator;

import com.accp.work1.entity.Stu;

/**
 * 
* <p>Title: MyComparator</p>  
* <p>Description:排序方法 </p>  
* @author Apple 

* @date 2019年4月2日
 */
public class MyComparator implements Comparator<Stu> {

	public String Tname;

	

	public MyComparator(String tname) {
		super();
		Tname = tname;
	}

	@Override
	public int compare(Stu o1, Stu o2) {
		//判断要进行升序还是降序
		if ("age".equals(Tname)) {
			//升序吧这是
			return o2.getStuAge()-o1.getStuAge();
		}
		else {
			//那这应该是降序
			return o1.getStuId()-o2.getStuId();
		}
	}
	
}
