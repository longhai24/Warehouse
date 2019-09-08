package com.accp.work1.test;

import com.accp.work1.dao.StuDao;
import com.accp.work1.entity.Stu;

/**
 * 
* <p>Title: StuTest</p>  
* <p>Description:测试类 </p>  
* @author Apple 

* @date 2019年4月2日
 */
public class StuTest {

	/**
	 * 
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuDao sdao = new StuDao();
		for (Stu sg : sdao.selectAllList()) {
			System.out.println(sg);
		}
	}

}
